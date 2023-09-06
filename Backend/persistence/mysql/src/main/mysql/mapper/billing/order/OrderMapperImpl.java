package com.example.mysql.mapper.billing.order;

import com.example.domain.billing.order.Order;
import com.example.mysql.entity.billing.order.OrderEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T20:22:52+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toDomain(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.orderId( orderEntity.getOrderId() );
        order.userId( orderEntity.getUserId() );
        order.productId( orderEntity.getProductId() );
        order.productOptionId( orderEntity.getProductOptionId() );
        order.productName( orderEntity.getProductName() );
        order.shopName( orderEntity.getShopName() );
        order.price( orderEntity.getPrice() );
        order.quantity( orderEntity.getQuantity() );
        order.productOptionName( orderEntity.getProductOptionName() );
        order.createdDt( orderEntity.getCreatedDt() );
        order.updatedDt( orderEntity.getUpdatedDt() );

        return order.build();
    }

    @Override
    public OrderEntity toEntity(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderEntity.OrderEntityBuilder orderEntity = OrderEntity.builder();

        orderEntity.orderId( order.getOrderId() );
        orderEntity.userId( order.getUserId() );
        orderEntity.productId( order.getProductId() );
        orderEntity.productOptionId( order.getProductOptionId() );
        orderEntity.productName( order.getProductName() );
        orderEntity.shopName( order.getShopName() );
        orderEntity.price( order.getPrice() );
        orderEntity.quantity( order.getQuantity() );
        orderEntity.productOptionName( order.getProductOptionName() );
        orderEntity.createdDt( order.getCreatedDt() );
        orderEntity.updatedDt( order.getUpdatedDt() );

        return orderEntity.build();
    }
}
