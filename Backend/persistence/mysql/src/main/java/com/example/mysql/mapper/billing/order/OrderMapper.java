package com.example.mysql.mapper.billing.order;

import com.example.domain.billing.order.Order;
import com.example.mysql.entity.billing.order.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper

public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toDomain(OrderEntity orderEntity);

    OrderEntity toEntity(Order order);
}
