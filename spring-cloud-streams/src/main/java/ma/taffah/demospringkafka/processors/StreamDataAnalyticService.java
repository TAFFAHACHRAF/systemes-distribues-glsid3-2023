package ma.taffah.demospringkafka.processors;

import ma.taffah.demospringkafka.entities.PageEvent;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.function.Function;

@Service
public class StreamDataAnalyticService {
    @Bean
    public Function<KStream<String, PageEvent>,KStream<String, Double>> kStreamFunction2(){
        return (input) -> input
                //.filter((k,v)->v.getDuration()>100)
                .map((k,v)->new KeyValue<>(v.getName(),(double)v.getDuration()))
                .groupBy((k,v)->k, Grouped.with(Serdes.String(),Serdes.Double()))
                .windowedBy(TimeWindows.of(Duration.ofSeconds(30)))
                //.count(Materialized.as("count-store"))
                .aggregate(()->0.0, (k,v,total)->total+v,Materialized.as("total-store"))
                .toStream()
                .map((k,v)->new KeyValue<>(k.key().toString(),v));
        };
}
