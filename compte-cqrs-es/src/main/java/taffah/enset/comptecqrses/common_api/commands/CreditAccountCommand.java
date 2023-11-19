package taffah.enset.comptecqrses.common_api.commands;

import lombok.Getter;

public class CreditAccountCommand extends BaseCommande{
    @Getter
    private double amount;
    @Getter
    private String currensy;

    public CreditAccountCommand(String id, double amount, String currensy) {
        super(id);
        this.amount = amount;
        this.currensy = currensy;
    }
}
