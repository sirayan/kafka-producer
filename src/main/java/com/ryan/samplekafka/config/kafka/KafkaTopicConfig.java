package com.ryan.samplekafka.config.kafka;

import java.util.HashMap;
import java.util.Map;

import com.ryan.samplekafka.config.AppConfig;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class KafkaTopicConfig {

    private AppConfig appConfig;

    @Autowired
    public KafkaTopicConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        log.info("" + appConfig.getBootstrapAddress());
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, appConfig.getBootstrapAddress());
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic() {
        log.info("Creating new topic");
        return new NewTopic(appConfig.getTopic1(), 1, (short) 1);
    }

}