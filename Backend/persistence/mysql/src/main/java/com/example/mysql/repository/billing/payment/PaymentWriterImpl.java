package com.example.mysql.repository.billing.payment;

import com.example.domain.billing.payment.Payment;
import com.example.mysql.mapper.billing.payment.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentWriterImpl implements PaymentWriter {
    private final PaymentEntityRepository paymentEntityRepository;
    private final PaymentMapper paymentMapper = PaymentMapper.INSTANCE;

    @Override
    public Payment create(Payment payment) {
        return paymentMapper.toDomain(paymentEntityRepository.save(paymentMapper.toEntity(payment)));
    }
}
