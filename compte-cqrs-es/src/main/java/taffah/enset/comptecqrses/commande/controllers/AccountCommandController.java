package taffah.enset.comptecqrses.commande.controllers;

import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.CommandGatewayFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taffah.enset.comptecqrses.common_api.commands.CreateAccountCommand;
import taffah.enset.comptecqrses.common_api.dtos.CreateAccountRequestDTO;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/commands/account")
public class AccountCommandController {
    private CommandGateway commandGateway;
    @PostMapping("/create")
    public CompletableFuture<String> createAccount(@RequestBody CreateAccountRequestDTO request){
        return commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
                request.getInitialBalance(),
                request.getCurrensy()
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exeptionHandler(Exception exception){
        ResponseEntity<String> entity=new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        return entity;
    }
}
