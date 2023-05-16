package com.example.entity.billing.payment;

import com.example.domain.billing.payment.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);
    Payment toDomain(PaymentEntity paymentEntity);

    PaymentEntity toEntity(Payment payment);
}
