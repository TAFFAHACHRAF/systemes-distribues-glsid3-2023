package taffah.enset.common_api.events;

import lombok.Getter;

public abstract class BaseEvent<EventId> {
    @Getter
    private EventId id;

    public BaseEvent(EventId id){
        this.id = id;
    }

}
