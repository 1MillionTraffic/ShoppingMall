package com.example.mysql.repository.user.jpa;

import com.example.mysql.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUid(String uid);
    Optional<UserEntity> findByUserId(Long id);
}
