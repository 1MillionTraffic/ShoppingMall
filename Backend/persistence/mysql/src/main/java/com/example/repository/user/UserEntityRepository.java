package com.example.repository.user;

import com.example.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}
