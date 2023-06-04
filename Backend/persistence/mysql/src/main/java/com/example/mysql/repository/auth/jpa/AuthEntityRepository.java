package com.example.mysql.repository.auth.jpa;

import com.example.mysql.entity.auth.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface AuthEntityRepository extends JpaRepository<AuthEntity, Long> {
    Optional<AuthEntity> findByUid(String uid);

    Optional<AuthEntity> findByEmail(String email);
}
