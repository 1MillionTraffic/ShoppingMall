package com.example.controller;

import com.example.request.payment.CreatePaymentRequest;
import com.example.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/payments")
@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<?> createPayment(@RequestBody CreatePaymentRequest request){
        return new ResponseEntity<>(paymentService.createPayment(request), HttpStatus.OK);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<?> findByPaymentId(@PathVariable("paymentId") Long paymentId){
        return new ResponseEntity<>(paymentService.findByPaymentId(paymentId), HttpStatus.OK);
    }
}
