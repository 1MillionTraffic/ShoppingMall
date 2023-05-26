package com.example.api.request.payment;

import com.example.domain.billing.payment.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CreatePaymentRequest {
    private Long userId;
    private Long shopId;
    private Integer money;

    public Payment toDomain() {
        return Payment.builder()
                .userId(userId)
                .shopId(shopId)
                .money(money)
                .build();
    }
}
