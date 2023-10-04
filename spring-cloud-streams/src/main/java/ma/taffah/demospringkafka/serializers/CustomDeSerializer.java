package ma.taffah.demospringkafka.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.taffah.demospringkafka.entities.PageEvent;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class CustomDeSerializer implements Deserializer<PageEvent> {
    @Override
    public PageEvent deserialize(String s, byte[] data) {
        try {
            return new ObjectMapper().readValue(new String(data),PageEvent.class);
        } catch (Exception e) {
            throw new SerializationException(e);
        }
    }
}
