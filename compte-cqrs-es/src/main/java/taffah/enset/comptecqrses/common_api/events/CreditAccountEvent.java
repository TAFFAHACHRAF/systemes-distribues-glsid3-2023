package taffah.enset.comptecqrses.common_api.events;

import lombok.Getter;

public class CreditAccountEvent extends BaseEvent{
    @Getter
    private double ammount;
    @Getter
    private String currensy;
    public CreditAccountEvent(String id, double ammount, String currensy) {
        super(id);
        this.ammount=ammount;
        this.currensy=currensy;
    }
}
