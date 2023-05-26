package com.example.response.order;


import com.example.domain.billing.order.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderResponse {
    private Long orderId;
    private Instant createdDt;
    private Instant updatedDt;

    public static OrderResponse of(Order order){
        return OrderResponse.builder()
                .orderId(order.getOrderId())
                .createdDt(order.getCreatedDt())
                .updatedDt(order.getUpdatedDt())
                .build();
    }
}
