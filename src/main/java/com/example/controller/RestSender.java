package com.example.controller;

import com.example.core.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSender {
    @Autowired
    private Producer producer;

    @GetMapping("/send/{topic}/{message}")
    public void send(
            @PathVariable String topic,
            @PathVariable String message) {
        System.out.println(topic);
        producer.sendMessage(topic,message);
    }
}
