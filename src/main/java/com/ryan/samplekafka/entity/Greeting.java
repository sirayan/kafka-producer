package com.ryan.samplekafka.entity;

import lombok.Data;

/**
 * Sample entity class/data to be sent
 */

@Data
public class Greeting {

    private String message;
    private String name;
}