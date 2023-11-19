package taffah.enset.query.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taffah.enset.common_api.queries.GetAccountQuery;
import taffah.enset.common_api.queries.GetAllAccountsQuery;
import taffah.enset.query.entities.Account;

import java.util.List;

@RestController
@RequestMapping("/query/accounts")
@Slf4j
@AllArgsConstructor
public class AccountQueryController {
    private QueryGateway queryGateway;

    @GetMapping
    public List<Account> getAllAccounts(){
        List<Account> response = queryGateway.query(new GetAllAccountsQuery(), ResponseTypes.multipleInstancesOf(Account.class)).join();
        // that means
        return  response;
    }

    @GetMapping("/{id}")
    public Account consultAccount(@PathVariable String id){
        Account account = queryGateway.query(new GetAccountQuery(id), ResponseTypes.instanceOf(Account.class)).join();
        return account;
    }
}
