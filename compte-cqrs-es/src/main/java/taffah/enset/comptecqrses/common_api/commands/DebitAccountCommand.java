package taffah.enset.comptecqrses.common_api.commands;

public class DebitAccountCommand extends BaseCommande{
    private double amount;
    private String currensy;

    public DebitAccountCommand(Object id, double amount, String currensy) {
        super(id);
        this.amount = amount;
        this.currensy = currensy;
    }
}
