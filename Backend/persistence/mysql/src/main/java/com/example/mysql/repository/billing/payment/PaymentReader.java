package com.example.mysql.repository.billing.payment;


import com.example.domain.billing.payment.Payment;

import java.util.List;

public interface PaymentReader {
    Payment findByPaymentId(Long paymentId);
    List<Payment> findByUserId(Long userId);
}
