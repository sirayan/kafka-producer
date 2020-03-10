package com.ryan.samplekafka.producer;

/**
 * Service for sending message to the topic
 */

import com.ryan.samplekafka.entity.Greeting;

public interface ProducerService {
    void sendMessage(Greeting greeting);
}