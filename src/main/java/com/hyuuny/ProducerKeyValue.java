package com.hyuuny;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerKeyValue {

    private final static String TOPIC_NAME = "test";

    private final static String BOOTSTRAP_SERVERS = "my-kafka:9092";


    public static void main(String[] args) {
        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        KafkaProducer<String, String> producer = new KafkaProducer<>(configs);

        ProducerRecord<String, String> record1 = new ProducerRecord<>(TOPIC_NAME, "apple", "red");
        producer.send(record1);
        ProducerRecord<String, String> record2 = new ProducerRecord<>(TOPIC_NAME, "banana", "yellow");
        producer.send(record2);
        producer.flush();
        producer.close();
    }

}
