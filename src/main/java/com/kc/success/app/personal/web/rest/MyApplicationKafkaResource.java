package com.kc.success.app.personal.web.rest;

import com.kc.success.app.personal.service.MyApplicationKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/my-application-kafka")
public class MyApplicationKafkaResource {

    private final Logger log = LoggerFactory.getLogger(MyApplicationKafkaResource.class);

    private MyApplicationKafkaProducer kafkaProducer;

    public MyApplicationKafkaResource(MyApplicationKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
