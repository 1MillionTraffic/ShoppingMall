package com.example.consumer.controller;

import com.example.consumer.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/consumer")
@RequiredArgsConstructor
public class ConsumerController {
    private final ConsumerService consumerService;

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
