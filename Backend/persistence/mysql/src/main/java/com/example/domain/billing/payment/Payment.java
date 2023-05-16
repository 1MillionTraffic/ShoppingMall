package com.example.domain.billing.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Payment {
    private Long paymentId;
    private Long userId;
    private Long shopId;
    private Integer money;
    private Instant createdDt;
    private Instant updatedDt;
}
