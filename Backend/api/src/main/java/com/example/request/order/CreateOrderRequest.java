package com.example.request.order;

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
public class CreateOrderRequest {
    private Long userId;
    private Long productId;
    private Long productOptionId;
    private String productName;
    private String shopName;
    private Integer price;
    private Integer quantity;
    private String productOptionName;

    public Order toDomain(){
        return Order.builder()
                .userId(userId)
                .productId(productId)
                .productOptionId(productOptionId)
                .productName(productName)
                .shopName(shopName)
                .price(price)
                .quantity(quantity)
                .productOptionName(productOptionName)
                .build();
    }
}
