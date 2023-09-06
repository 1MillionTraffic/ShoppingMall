package com.example.mysql.mapper.billing.payment;

import com.example.domain.billing.payment.Payment;
import com.example.mysql.entity.billing.payment.PaymentEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T20:22:52+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public Payment toDomain(PaymentEntity paymentEntity) {
        if ( paymentEntity == null ) {
            return null;
        }

        Payment.PaymentBuilder payment = Payment.builder();

        payment.paymentId( paymentEntity.getPaymentId() );
        payment.userId( paymentEntity.getUserId() );
        payment.shopId( paymentEntity.getShopId() );
        payment.money( paymentEntity.getMoney() );
        payment.createdDt( paymentEntity.getCreatedDt() );
        payment.updatedDt( paymentEntity.getUpdatedDt() );

        return payment.build();
    }

    @Override
    public PaymentEntity toEntity(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentEntity.PaymentEntityBuilder paymentEntity = PaymentEntity.builder();

        paymentEntity.paymentId( payment.getPaymentId() );
        paymentEntity.userId( payment.getUserId() );
        paymentEntity.shopId( payment.getShopId() );
        paymentEntity.money( payment.getMoney() );
        paymentEntity.createdDt( payment.getCreatedDt() );
        paymentEntity.updatedDt( payment.getUpdatedDt() );

        return paymentEntity.build();
    }
}
