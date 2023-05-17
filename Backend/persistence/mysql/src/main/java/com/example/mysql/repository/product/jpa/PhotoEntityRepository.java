package com.example.mysql.repository.product.jpa;

import com.example.mysql.entity.product.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoEntityRepository extends JpaRepository<PhotoEntity, Long> {
}
