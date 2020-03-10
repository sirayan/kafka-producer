package com.ryan.samplekafka.config.kafka;

import java.util.HashMap;
import java.util.Map;

import com.ryan.samplekafka.config.AppConfig;
import com.ryan.samplekafka.entity.Greeting;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaProducerConfig {

    @Autowired
    private AppConfig appConfig;

    @Bean
    public ProducerFactory<String, Greeting> producerFactory() {

        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, appConfig.getBootstrapAddress());
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, Greeting> greetingKafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Autowired
    private KafkaTemplate<String, Greeting> kafkaTemplate;

    public void sendMessage(Greeting greeting) {
        kafkaTemplate.send(appConfig.getTopic1(), greeting);
    }

}
