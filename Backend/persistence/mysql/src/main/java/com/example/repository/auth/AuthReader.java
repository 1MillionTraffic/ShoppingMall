package com.example.repository.auth;

import com.example.domain.auth.Auth;

public interface AuthReader {
    Auth findByUid(String uid);
}
