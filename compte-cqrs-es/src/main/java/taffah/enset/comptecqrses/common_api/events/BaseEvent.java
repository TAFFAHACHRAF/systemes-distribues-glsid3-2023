package taffah.enset.comptecqrses.common_api.events;

import lombok.Getter;

public abstract class BaseEvent <T>{
    @Getter
    private String id;
    public BaseEvent(String id){
        this.id=id;
    }
}
