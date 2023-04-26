package com.example.entity.product;


import com.example.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@NoArgsConstructor

public class ProductMapper {
    public Product toDomain(ProductEntity productEntity){
        return Product.builder()
                .productId(productEntity.getProductId())
                .productName(productEntity.getProductName())
                .build();
    }

    public ProductEntity toEntity(Product product){
        return ProductEntity.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .build();
    }
}
