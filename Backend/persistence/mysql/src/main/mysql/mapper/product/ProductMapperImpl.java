package com.example.mysql.mapper.product;

import com.example.domain.product.Product;
import com.example.mysql.entity.product.ProductEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T20:22:52+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toDomain(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.productId( productEntity.getProductId() );
        product.productName( productEntity.getProductName() );

        return product.build();
    }

    @Override
    public ProductEntity toEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity.ProductEntityBuilder productEntity = ProductEntity.builder();

        productEntity.productId( product.getProductId() );
        productEntity.productName( product.getProductName() );

        return productEntity.build();
    }
}
