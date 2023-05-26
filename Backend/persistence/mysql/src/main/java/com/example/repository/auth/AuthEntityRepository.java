package com.example.repository.auth;

import com.example.entity.auth.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface AuthEntityRepository extends JpaRepository<AuthEntity, Long> {
    Optional<AuthEntity> findByUid(String uid);
}
