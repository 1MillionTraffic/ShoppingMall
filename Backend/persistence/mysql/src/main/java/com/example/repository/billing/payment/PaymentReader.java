package com.example.repository.billing.payment;

import com.example.domain.billing.payment.Payment;

public interface PaymentReader {
    Payment findByPaymentId(Long paymentId);
}
