package com.kc.success.app.personal.web.rest;

import com.kc.success.app.personal.MyApplicationApp;
import com.kc.success.app.personal.config.TestSecurityConfiguration;
import com.kc.success.app.personal.service.MyApplicationKafkaProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EmbeddedKafka
@SpringBootTest(classes = {MyApplicationApp.class, TestSecurityConfiguration.class})
public class MyApplicationKafkaResourceIT {

    @Autowired
    private MyApplicationKafkaProducer kafkaProducer;

    private MockMvc restMockMvc;

    @BeforeEach
    public void setup() {
        MyApplicationKafkaResource kafkaResource = new MyApplicationKafkaResource(kafkaProducer);

        this.restMockMvc = MockMvcBuilders.standaloneSetup(kafkaResource)
            .build();
    }

    @Test
    public void sendMessageToKafkaTopic() throws Exception {
        restMockMvc.perform(post("/api/my-application-kafka/publish?message=yolo"))
            .andExpect(status().isOk());
    }
}
