package com.example.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    private final int DEFAULT_NUM_PARTITION = 1;
    private final short DEFAULT_REPLICATION_FACTOR = (short)1;

    @Bean
    public NewTopic testTopic1(){
        return new NewTopic("test_topic_1", DEFAULT_NUM_PARTITION, DEFAULT_REPLICATION_FACTOR);
    }

    @Bean
    public NewTopic testTopic2(){
        return new NewTopic("test_topic_2", DEFAULT_NUM_PARTITION, DEFAULT_REPLICATION_FACTOR);
    }

    @Bean
    public NewTopic createOrder(){
        return new NewTopic("create_order", DEFAULT_NUM_PARTITION, DEFAULT_REPLICATION_FACTOR);
    }
}
