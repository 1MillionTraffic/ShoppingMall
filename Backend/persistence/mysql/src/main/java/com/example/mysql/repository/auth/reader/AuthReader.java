package com.example.mysql.repository.auth.reader;

import com.example.domain.auth.Auth;

public interface AuthReader {
    Auth findByUid(String uid);
    Auth findByEmail(String email);
}
