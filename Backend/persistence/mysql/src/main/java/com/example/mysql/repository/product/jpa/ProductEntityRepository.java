package com.example.mysql.repository.product.jpa;

import com.example.mysql.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
}
