package com.example.mysql.repository.product.jpa;

import com.example.mysql.entity.product.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Long> {
}
