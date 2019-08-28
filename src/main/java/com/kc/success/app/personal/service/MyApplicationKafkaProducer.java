package com.kc.success.app.personal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyApplicationKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(MyApplicationKafkaProducer.class);
    private static final String TOPIC = "topic_myapplication";

    private KafkaTemplate<String, String> kafkaTemplate;

    public MyApplicationKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        log.info("Producing message to {} : {}", TOPIC, message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
