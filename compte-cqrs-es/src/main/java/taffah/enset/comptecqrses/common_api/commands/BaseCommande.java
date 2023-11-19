package taffah.enset.comptecqrses.common_api.commands;

import lombok.Getter;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import org.hibernate.annotations.Immutable;

public abstract class BaseCommande <T>{
    @TargetAggregateIdentifier
    @Getter
    private T id;

    public BaseCommande(T id){
        this.id=id;
    }
}
