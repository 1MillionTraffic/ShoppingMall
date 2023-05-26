package com.example.mysql.repository.billing.payment;


import com.example.domain.billing.payment.Payment;

public interface PaymentWriter {
    Payment create(Payment payment);
}
