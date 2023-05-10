package com.example.mongodb.entity;

import com.example.mongodb.domain.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    Cart toDomain(CartEntity cartEntity);

    CartEntity toEntity(Cart cart);
}
