package com.example.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaAdminConfig {
    @Value(value = "${kafka.bootstrapServerAddress}")
    private String bootStrapAddress;
    @Value(value = "${kafka.topic.test}")
    private String testTopic;
    @Bean
    public KafkaAdmin kafkaAdmin(){
        Map<String,Object> configs= new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,bootStrapAddress);
        return new KafkaAdmin(configs);
    }

    public NewTopic topic1(){
        return new NewTopic(testTopic,1,(short)1);
    }
}
