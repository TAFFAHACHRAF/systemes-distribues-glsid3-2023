package taffah.enset.comptecqrses.commande.aggregates;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import taffah.enset.comptecqrses.common_api.commands.CreateAccountCommand;
import taffah.enset.comptecqrses.common_api.ennums.AccountStatus;
import taffah.enset.comptecqrses.common_api.events.CreateAccountEvent;

@Aggregate
public class AccountAggreagates {
    @AggregateIdentifier
    private String accountId;
    private double balance;
    private String currensy;
    private AccountStatus status;
    public AccountAggreagates(){}
    @CommandHandler
    public AccountAggreagates(CreateAccountCommand createAccountCommand){
        if(createAccountCommand.getInitialBalance() < 0) throw new RuntimeException("Impossible");
        AggregateLifecycle.apply(new CreateAccountEvent(
                createAccountCommand.getId(),
                createAccountCommand.getInitialBalance(),
                createAccountCommand.getCurrensy()
        ))
    }
}
