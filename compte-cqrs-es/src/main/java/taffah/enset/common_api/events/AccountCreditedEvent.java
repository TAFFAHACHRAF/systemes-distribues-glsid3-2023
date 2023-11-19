package taffah.enset.common_api.events;

import lombok.Getter;

import java.util.Date;

public class AccountCreditedEvent extends BaseEvent<String>{

    @Getter
    private double amount;
    @Getter
    private String currency;

    @Getter
    private Date operationDate;

    public AccountCreditedEvent(String s, double amount, String currency, Date operationDate) {
        super(s);
        this.amount = amount;
        this.currency = currency;
        this.operationDate = operationDate;
    }
}
