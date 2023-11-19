package taffah.enset.comptecqrses.common_api.events;

import lombok.Getter;

public class CreateAccountEvent extends BaseEvent<String>{
    @Getter
    private double initialBalance;
    @Getter
    private String currensy;
    public CreateAccountEvent(String id,double initialBalance,String currensy) {
        super(id);
        this.initialBalance=initialBalance;
        this.currensy=currensy;
    }
}
