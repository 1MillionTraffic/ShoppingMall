package com.example.mysql.repository.review.jpa;

import com.example.mysql.entity.review.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeEntityRepository extends JpaRepository<LikeEntity, Long> {
}
