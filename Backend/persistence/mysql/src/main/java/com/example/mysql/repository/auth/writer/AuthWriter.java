package com.example.mysql.repository.auth.writer;

import com.example.domain.auth.Auth;

public interface AuthWriter {
    void save(Auth auth);
}
