package com.example.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @Value(value = "${kafka.topic.test}")
    private String topic;
    public void sendMessage(String message){
        sendMessage(topic,message);
    }
    public void sendMessage(String topic,String message){
        LOGGER.info("sending payload:{} to topic :{}",message,topic);
        kafkaTemplate.send(topic,message);
    }

}
