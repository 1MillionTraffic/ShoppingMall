package com.example.mysql.mapper.product;

import com.example.mysql.domain.product.Sale;
import com.example.mysql.entity.product.SaleEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T20:22:52+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class SaleMapperImpl implements SaleMapper {

    @Override
    public Sale toDomain(SaleEntity saleEntity) {
        if ( saleEntity == null ) {
            return null;
        }

        Sale.SaleBuilder sale = Sale.builder();

        sale.saleId( saleEntity.getSaleId() );

        return sale.build();
    }

    @Override
    public SaleEntity toEntity(Sale sale) {
        if ( sale == null ) {
            return null;
        }

        SaleEntity.SaleEntityBuilder saleEntity = SaleEntity.builder();

        saleEntity.saleId( sale.getSaleId() );

        return saleEntity.build();
    }
}
