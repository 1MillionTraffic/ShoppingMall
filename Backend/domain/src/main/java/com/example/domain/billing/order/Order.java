package com.example.domain.billing.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Order {
    private Long orderId;
    private Long userId;
    private Long productId;
    private Long productOptionId;
    private String productName;
    private String shopName;
    private Integer price;
    private Integer quantity;
    private String productOptionName;
    private Instant createdDt;
    private Instant updatedDt;
}
