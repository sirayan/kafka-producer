package com.ryan.samplekafka;

import com.ryan.samplekafka.entity.Greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SampleKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleKafkaApplication.class, args);
	}

}
