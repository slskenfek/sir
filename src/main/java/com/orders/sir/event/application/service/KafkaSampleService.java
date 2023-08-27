package com.orders.sir.event.application.service;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaSampleService {

    @KafkaListener(topics = "", groupId = "group-sample")
    public void sampleConsume() {

    }

}
