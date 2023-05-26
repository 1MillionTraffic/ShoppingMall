package com.example.mysql.repository.product.jpa;

import com.example.mysql.entity.product.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagEntityRepository extends JpaRepository<TagEntity, Long> {
}
