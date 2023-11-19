package taffah.enset.comptecqrses.common_api.commands;

public class CreditAccountCommand extends BaseCommande{
    private double amount;
    private String currensy;

    public CreditAccountCommand(String id, double amount, String currensy) {
        super(id);
        this.amount = amount;
        this.currensy = currensy;
    }
}
