package taffah.enset.comptecqrses.common_api.commands;

public class CreateAccountCommand extends BaseCommande{
    private double initialBalance;
    private String currensy;

    public CreateAccountCommand(String id, double initialBalance, String currensy) {
        super(id);
        this.initialBalance = initialBalance;
        this.currensy = currensy;
    }
}
