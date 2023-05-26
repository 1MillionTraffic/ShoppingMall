package com.example.mysql.mapper.product;


import com.example.mysql.domain.product.Shop;
import com.example.mysql.entity.product.ShopEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ShopMapper {
    ShopMapper INSTANCE = Mappers.getMapper(ShopMapper.class);

    Shop toDomain(ShopEntity shopEntity);

    ShopEntity toEntity(Shop shop);
}
