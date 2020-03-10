package com.ryan.samplekafka.producer;

import com.ryan.samplekafka.config.AppConfig;
import com.ryan.samplekafka.entity.Greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {

    private KafkaTemplate<String, Greeting> kafkaTemplate;
    private AppConfig appConfig;

    @Autowired
    public ProducerServiceImpl(KafkaTemplate<String, Greeting> kafkaTemplate, AppConfig appConfig) {
        this.kafkaTemplate = kafkaTemplate;
        this.appConfig = appConfig;
    }

    @Override
    public void sendMessage(Greeting greeting) {
        kafkaTemplate.send(appConfig.getTopic1(), greeting);
    }

}