package com.example.repository.product;

import com.example.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
}
