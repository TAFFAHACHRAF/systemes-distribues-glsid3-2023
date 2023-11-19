package taffah.enset.common_api.events;

import lombok.Getter;
import taffah.enset.common_api.enumerations.AccountStatus;

public class AccountActivatedEvent  extends BaseEvent<String> {

    @Getter
    private AccountStatus accountStatus;

    public AccountActivatedEvent(String s, AccountStatus accountStatus) {
        super(s);
        this.accountStatus = accountStatus;
    }
}
