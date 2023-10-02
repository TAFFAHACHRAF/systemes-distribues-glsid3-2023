package org.example;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class StreamConsumer {
    private String KAFKA_BROKER_URL="192.168.43.22:9092"; private String TOPIC_NAME="testTopic";
    public static void main(String[] args) {
        new StreamConsumer();
    }
    public StreamConsumer() {
        Properties properties=new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,KAFKA_BROKER_URL);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"sample-group-test");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"true");
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"1000");
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,"30000");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<Integer, String> kafkaConsumer = new KafkaConsumer<Integer, String>(properties);
        kafkaConsumer.subscribe(Collections.singletonList(TOPIC_NAME));
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(()->{
            System.out.println("----------------------------------------");
            ConsumerRecords<Integer,String> consumerRecords=kafkaConsumer.poll(Duration.ofMillis(10));
            consumerRecords.forEach(cr->{
                System.out.println("Key=>"+cr.key()+", Value=>"+cr.value()+", offset=>"+cr.offset());
            });
        },1000,1000, TimeUnit.MILLISECONDS);
    }
}