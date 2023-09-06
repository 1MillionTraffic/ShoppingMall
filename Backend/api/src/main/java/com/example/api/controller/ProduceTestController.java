package com.example.api.controller;

import com.example.kafka.enums.Channel;
import com.example.kafka.publisher.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/producer")
@RequiredArgsConstructor
public class ProduceTestController {
    private final Publisher publisher;

    @PostMapping("/topic1")
    public ResponseEntity<?> produceMessageTopic1(){
        publisher.publish(Channel.TEST_CHANNEL_1, "test_topic_1");

        return ResponseEntity.ok("test_topic_1");
    }
}
