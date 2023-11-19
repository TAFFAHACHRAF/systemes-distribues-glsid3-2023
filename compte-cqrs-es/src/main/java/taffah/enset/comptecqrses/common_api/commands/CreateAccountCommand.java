package taffah.enset.comptecqrses.common_api.commands;

import lombok.Getter;

public class CreateAccountCommand extends BaseCommande{
    @Getter
    private double initialBalance;
    @Getter
    private String currensy;

    public CreateAccountCommand(String id, double initialBalance, String currensy) {
        super(id);
        this.initialBalance = initialBalance;
        this.currensy = currensy;
    }
}
