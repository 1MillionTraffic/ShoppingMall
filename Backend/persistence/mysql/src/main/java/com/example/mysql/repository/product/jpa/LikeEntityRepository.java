package com.example.mysql.repository.product.jpa;

import com.example.mysql.entity.product.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeEntityRepository extends JpaRepository<LikeEntity, Long> {
}
