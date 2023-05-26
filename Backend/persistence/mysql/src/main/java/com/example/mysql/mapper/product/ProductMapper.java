package com.example.mysql.mapper.product;


import com.example.domain.product.Product;
import com.example.mysql.entity.product.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toDomain(ProductEntity productEntity);

    ProductEntity toEntity(Product product);
}
