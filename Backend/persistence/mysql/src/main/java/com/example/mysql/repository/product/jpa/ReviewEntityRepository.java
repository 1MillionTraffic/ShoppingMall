package com.example.mysql.repository.product.jpa;

import com.example.mysql.entity.product.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewEntityRepository extends JpaRepository<ReviewEntity, Long> {
}
