package taffah.enset.commands.aggregates;


import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import taffah.enset.common_api.commands.CreateAccountCommand;
import taffah.enset.common_api.commands.CreditAccountCommand;
import taffah.enset.common_api.commands.DebitAccountCommand;
import taffah.enset.common_api.enumerations.AccountStatus;
import taffah.enset.common_api.events.AccountActivatedEvent;
import taffah.enset.common_api.events.AccountCreatedEvent;
import taffah.enset.common_api.events.AccountCreditedEvent;
import taffah.enset.common_api.events.AccountDebitedEvent;
import taffah.enset.common_api.exceptions.InsufficientBalanceToDebitException;
import taffah.enset.common_api.exceptions.InsufficientCreditAmount;
import taffah.enset.common_api.exceptions.NegativeAmountException;

import java.util.Date;

@Aggregate
//@NoArgsConstructor // Important
public class AccountAggregate {
    @AggregateIdentifier
    private String accountId; // identifies the aggregation
    // This id will be mapped to the TargetAggregateIdentifier in the baseCommand
    private double balance;
    private String currency;
    private AccountStatus status;

    public AccountAggregate(){
        // Required by Axon
    }

    @CommandHandler // Subscribe to Command Bus, and listen to the CreateAccountCommand events
    public AccountAggregate(CreateAccountCommand createAccountCommand){
        // Business logic
        // Every new account well have a new aggregate
        if(createAccountCommand.getInitialBalance() < 0) throw new RuntimeException("Invalid Initial Balance | Negative");
        AggregateLifecycle.apply(new AccountCreatedEvent(
                // Command to event
                createAccountCommand.getId(),
                createAccountCommand.getInitialBalance(),
                createAccountCommand.getCurrency(),
                AccountStatus.ACTIVATED
        ));
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent accountCreatedEvent){

        // The Aggregate is the Object Status
        this.accountId = accountCreatedEvent.getId();
        this.balance = accountCreatedEvent.getInitialBalance();
        this.currency = accountCreatedEvent.getCurrency();

        this.status = AccountStatus.CREATED;
        AggregateLifecycle.apply(new AccountActivatedEvent(accountCreatedEvent.getId(), AccountStatus.ACTIVATED));
    }

    // create an on() function for our event

    @EventSourcingHandler // Changing the aggregate status
    public void on(AccountActivatedEvent accountActivatedEvent){
        this.status = accountActivatedEvent.getAccountStatus();
    }

    @CommandHandler // when the command will be sent to the Commands bus, this method will be invoked
    public void handle(CreditAccountCommand creditAccountCommand){
        // business logic
        if(creditAccountCommand.getAmount() <= 100) throw new InsufficientCreditAmount("Credit Amount can not be lower than 100.");
        // Business logic is fine ? SO
        // immetre un événement
        // immit an event
        AggregateLifecycle.apply(new AccountCreditedEvent(
                creditAccountCommand.getId(),
                creditAccountCommand.getAmount(),
                creditAccountCommand.getCurrency(),
                new Date()
        ));
    }

    @EventSourcingHandler
    public void on(AccountCreditedEvent accountCreditedEvent){
        this.balance += accountCreditedEvent.getAmount();
    }



    // Debit command
    @CommandHandler
    public void handler(DebitAccountCommand debitAccountCommand){
        if(debitAccountCommand.getAmount() < 0) throw new NegativeAmountException("Amount can't be negative");
        //if(this.balance < debitAccountCommand.getAmount()) throw new InsufficientBalanceToDebitException(String.format("Amount must be lower than the balance (%s)", this.balance));
        if(this.balance < debitAccountCommand.getAmount()) throw new InsufficientBalanceToDebitException(String.format("Amount must be lower than the balance (%s)", this.balance));
        // emmit event
        AggregateLifecycle.apply(new AccountDebitedEvent(
                debitAccountCommand.getId(),
                debitAccountCommand.getAmount(),
                debitAccountCommand.getCurrency(),
                new Date()
        ));
    }

    @EventSourcingHandler
    public void on(AccountDebitedEvent accountDebitedEvent){
        this.balance -= accountDebitedEvent.getAmount();
    }


}
