package taffah.enset.common_api.queries;

import lombok.Getter;

public class GetAccountQuery {
    @Getter
    private String accountId;

    public GetAccountQuery(String accountId) {
        this.accountId = accountId;
    }
}
