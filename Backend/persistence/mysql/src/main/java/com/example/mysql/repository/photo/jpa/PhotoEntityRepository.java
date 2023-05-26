package com.example.mysql.repository.photo.jpa;

import com.example.mysql.entity.photo.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoEntityRepository extends JpaRepository<PhotoEntity, Long> {
}
