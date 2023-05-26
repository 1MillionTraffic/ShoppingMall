package com.example.mysql.mapper.billing.payment;

import com.example.domain.billing.payment.Payment;
import com.example.mysql.entity.billing.payment.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    Payment toDomain(PaymentEntity paymentEntity);

    PaymentEntity toEntity(Payment payment);
}
