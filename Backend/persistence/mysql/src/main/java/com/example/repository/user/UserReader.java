package com.example.repository.user;

import com.example.domain.user.User;

import java.util.Optional;

public interface UserReader {
    User findByUid(String uid);
}
