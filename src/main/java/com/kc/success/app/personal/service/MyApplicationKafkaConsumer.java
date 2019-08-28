package com.kc.success.app.personal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MyApplicationKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(MyApplicationKafkaConsumer.class);
    private static final String TOPIC = "topic_myapplication";

    @KafkaListener(topics = "topic_myapplication", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
