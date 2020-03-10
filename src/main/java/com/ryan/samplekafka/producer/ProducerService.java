package com.ryan.samplekafka.producer;

import com.ryan.samplekafka.entity.Greeting;

public interface ProducerService {
    void sendMessage(Greeting greeting);
}