package com.ryan.samplekafka.entity;

import lombok.Data;

@Data
public class Greeting {

    private String message;
    private String name;
}