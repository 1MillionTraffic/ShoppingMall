package com.example.entity.order;

import com.example.domain.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@NoArgsConstructor
public class OrderMapper {
    public Order toDomain(OrderEntity orderEntity){
        return Order.builder()
                .orderId(orderEntity.getOrderId())
                .userId(orderEntity.getUserId())
                .productId(orderEntity.getProductId())
                .productOptionId(orderEntity.getProductOptionId())
                .productName(orderEntity.getProductName())
                .shopName(orderEntity.getShopName())
                .price(orderEntity.getPrice())
                .quantity(orderEntity.getQuantity())
                .productOptionName(orderEntity.getProductOptionName())
                .createdDt(orderEntity.getCreatedDt())
                .updatedDt(orderEntity.getUpdatedDt())
                .build();
    }

    public OrderEntity toEntity(Order order){
        return OrderEntity.builder()
                .orderId(order.getOrderId())
                .userId(order.getUserId())
                .productId(order.getProductId())
                .productOptionId(order.getProductOptionId())
                .productName(order.getProductName())
                .shopName(order.getShopName())
                .price(order.getPrice())
                .quantity(order.getQuantity())
                .productOptionName(order.getProductOptionName())
                .createdDt(order.getCreatedDt())
                .updatedDt(order.getUpdatedDt())
                .build();
    }
}
