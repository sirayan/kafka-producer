package com.ryan.samplekafka.rest;

import com.ryan.samplekafka.entity.Greeting;
import com.ryan.samplekafka.producer.ProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class ProducerRestController {

    private ProducerService producerService;

    @Autowired
    public ProducerRestController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/message")
    public ResponseEntity<?> sendMessage() {
        Greeting greeting = new Greeting();
        greeting.setMessage("Helloooo");
        greeting.setName("Ryaannnnnnnnnn");
        producerService.sendMessage(greeting);
        return ResponseEntity.ok("Message sent");
    }
}