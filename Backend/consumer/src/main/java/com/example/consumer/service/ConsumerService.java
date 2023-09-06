package com.example.consumer.service;

import com.example.domain.product.Product;
import com.example.kafka.enums.Channel;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "test_topic_1", groupId = "group1")
    public void consumeTopic1(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition){
        System.out.println("message: " +  message + " partition: " + partition);
    }

    @KafkaListener(topics = "create_order", groupId = "group1")
    public void createOrder(@Payload Product product, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition){
        System.out.println("product_id: " + product.getProductId());
    }
}
