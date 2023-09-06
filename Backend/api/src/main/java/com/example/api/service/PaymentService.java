package com.example.api.service;

import com.example.api.request.payment.CreatePaymentRequest;
import com.example.domain.billing.payment.Payment;
import com.example.mysql.repository.billing.payment.PaymentReader;
import com.example.mysql.repository.billing.payment.PaymentWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentWriter paymentWriter;
    private final PaymentReader paymentReader;

    @Transactional(value = "billingTransactionManager")
    public Payment createPayment(CreatePaymentRequest request) {
        return paymentWriter.create(request.toDomain());
    }

    @Transactional(value = "billingTransactionManager")
    public Payment findByPaymentId(Long paymentId) {
        return paymentReader.findByPaymentId(paymentId);
    }

    public List<Payment> findByUserId(Long userId){return paymentReader.findByUserId(userId);}
}
