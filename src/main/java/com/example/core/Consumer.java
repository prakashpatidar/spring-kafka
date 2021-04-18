package com.example.core;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    /*@KafkaListener(
            topicPartitions = @TopicPartition
                    (
                            topic = "test3",
                            partitionOffsets = {
                                    @PartitionOffset(partition = "0",initialOffset = "5")
                            }
            )
    )
    public void listen(String message){
        System.out.println("received... : "+message);
    }*/
    @KafkaListener(topics = "test3",groupId = "g1",containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listenWithHeader(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.OFFSET) long offSet
    ) {
        System.out.println("Received: " + message + " from partition: " +partition+ " and offset: "+ offSet);
    }
}
