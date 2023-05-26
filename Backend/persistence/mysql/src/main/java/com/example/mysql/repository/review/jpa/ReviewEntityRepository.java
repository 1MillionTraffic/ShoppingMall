package com.example.mysql.repository.review.jpa;

import com.example.mysql.entity.review.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewEntityRepository extends JpaRepository<ReviewEntity, Long> {
    Optional<ReviewEntity> findByPostId(Long postId);
}
