package com.example.repository.auth;

import com.example.domain.auth.Auth;

public interface AuthWriter {
    void save(Auth auth);
}
