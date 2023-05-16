package com.example.domain.billing.mileage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Mileage {
    private Long mileageId;
    private Long userId;
    private Long orderId;
    private Integer mileage;
}
