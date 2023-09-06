package com.example.mysql.repository.billing.payment;

import com.example.mysql.entity.billing.payment.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentEntityRepository extends JpaRepository<PaymentEntity, Long> {
    List<PaymentEntity> findByUserId(Long userId);
}
