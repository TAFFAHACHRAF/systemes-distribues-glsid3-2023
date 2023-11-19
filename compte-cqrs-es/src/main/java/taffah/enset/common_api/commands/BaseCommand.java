package taffah.enset.common_api.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class BaseCommand<IDType> {
    @TargetAggregateIdentifier
    // the command ID is the identifier that will be used in the
    // Aggregate

    @Getter // because the commands are immutable objects
    // So we will not have the setters
    // Just a constructor for initializing
    private IDType id;

    public BaseCommand(IDType id) {
        this.id = id;
    }


}
