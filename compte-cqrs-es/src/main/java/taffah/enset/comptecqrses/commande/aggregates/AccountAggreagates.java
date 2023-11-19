package taffah.enset.comptecqrses.commande.aggregates;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import taffah.enset.comptecqrses.common_api.ennums.AccountStatus;

@AllArgsConstructor
@NoArgsConstructor
public class AccountAggreagates {
    @AggregateIdentifier
    private String accountId;
    private double balance;
    private String currensy;
    private AccountStatus status;
}
