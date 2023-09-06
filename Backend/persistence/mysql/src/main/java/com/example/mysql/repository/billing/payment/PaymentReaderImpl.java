package com.example.mysql.repository.billing.payment;

import com.example.domain.billing.payment.Payment;
import com.example.mysql.mapper.billing.payment.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PaymentReaderImpl implements PaymentReader {
    private final PaymentEntityRepository paymentEntityRepository;
    private final PaymentMapper paymentMapper = PaymentMapper.INSTANCE;

    @Override
    public Payment findByPaymentId(Long paymentId) {
        return paymentMapper.toDomain(paymentEntityRepository.findById(paymentId).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public List<Payment> findByUserId(Long userId) {
        return paymentEntityRepository.findByUserId(userId).stream()
                .map(paymentMapper::toDomain)
                .collect(Collectors.toList());
    }
}
