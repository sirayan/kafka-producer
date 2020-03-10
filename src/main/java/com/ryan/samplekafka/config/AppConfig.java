package com.ryan.samplekafka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@NoArgsConstructor
@Data
@ConfigurationProperties(prefix = "kafka")
public class AppConfig {

    private String bootstrapAddress;
    private String topic1;
}