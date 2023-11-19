package taffah.enset.comptecqrses.common_api.commands;

import lombok.Getter;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import org.hibernate.annotations.Immutable;

public abstract class BaseCommande <T>{
    @TargetAggregateIdentifier
    @Getter
    private String id;

    public BaseCommande(String id){
        this.id=id;
    }
}
