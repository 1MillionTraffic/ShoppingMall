package com.example.repository.billing.payment;

import com.example.entity.billing.payment.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentEntityRepository extends JpaRepository<PaymentEntity, Long> {
}
