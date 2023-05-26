package com.example.response.payment;

import com.example.domain.billing.payment.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PaymentResponse {
    private Long paymentId;

    public static PaymentResponse of(Payment payment){
        return PaymentResponse.builder()
                .paymentId(payment.getPaymentId())
                .build();
    }
}
