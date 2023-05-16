package com.example.controller;

import com.example.request.order.CreateOrderRequest;
import com.example.response.order.OrderResponse;
import com.example.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/orders")
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest request){
        return new ResponseEntity<>(OrderResponse.of(orderService.createOrder(request)), HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> findByOrderId(@PathVariable("orderId") Long orderId){
        return new ResponseEntity<>(orderService.findByOrderId(orderId), HttpStatus.OK);
    }
}
