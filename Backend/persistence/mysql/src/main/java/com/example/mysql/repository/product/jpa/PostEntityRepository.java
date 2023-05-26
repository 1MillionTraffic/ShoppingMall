package com.example.mysql.repository.product.jpa;

import com.example.mysql.entity.product.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostEntityRepository extends JpaRepository<PostEntity, Long> {
}
