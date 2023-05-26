package com.example.mysql.repository.product.jpa;

import com.example.mysql.entity.product.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleEntityRepository extends JpaRepository<SaleEntity, Long> {
}
