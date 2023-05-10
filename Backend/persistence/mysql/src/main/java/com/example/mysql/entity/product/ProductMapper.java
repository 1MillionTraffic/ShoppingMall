package com.example.mysql.entity.product;


import com.example.mysql.domain.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toDomain(ProductEntity productEntity);

    ProductEntity toEntity(Product product);
}
