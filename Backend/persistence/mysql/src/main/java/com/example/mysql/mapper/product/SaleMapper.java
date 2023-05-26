package com.example.mysql.mapper.product;


import com.example.mysql.domain.product.Sale;
import com.example.mysql.entity.product.SaleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface SaleMapper {
    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);

    Sale toDomain(SaleEntity saleEntity);

    SaleEntity toEntity(Sale sale);
}
