package com.example.mysql.repository.billing.payment;

import com.example.domain.billing.payment.Payment;
import com.example.mysql.entity.billing.payment.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentReaderImpl implements PaymentReader{
    private final PaymentEntityRepository paymentEntityRepository;
    private final PaymentMapper paymentMapper = PaymentMapper.INSTANCE;
    @Override
    public Payment findByPaymentId(Long paymentId) {
        return paymentMapper.toDomain(paymentEntityRepository.findById(paymentId).orElseThrow(IllegalArgumentException::new));
    }
}
