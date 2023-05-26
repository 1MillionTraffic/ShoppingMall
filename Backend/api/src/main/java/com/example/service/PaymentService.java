package com.example.service;

import com.example.domain.billing.payment.Payment;
import com.example.mysql.repository.billing.payment.PaymentReader;
import com.example.mysql.repository.billing.payment.PaymentWriter;
import com.example.request.payment.CreatePaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentWriter paymentWriter;
    private final PaymentReader paymentReader;

    @Transactional(value = "billingTransactionManager")
    public Payment createPayment(CreatePaymentRequest request){
        return paymentWriter.create(request.toDomain());
    }

    @Transactional(value = "billingTransactionManager")
    public Payment findByPaymentId(Long paymentId){
        return paymentReader.findByPaymentId(paymentId);
    }
}
