package com.example.api.controller;

import com.example.api.request.payment.CreatePaymentRequest;
import com.example.api.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/payments")
@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<?> createPayment(@RequestBody CreatePaymentRequest request) {
        return new ResponseEntity<>(paymentService.createPayment(request), HttpStatus.OK);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<?> findByPaymentId(@PathVariable("paymentId") Long paymentId) {
        return new ResponseEntity<>(paymentService.findByPaymentId(paymentId), HttpStatus.OK);
    }
}
