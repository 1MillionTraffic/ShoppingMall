package com.example.mysql.repository.user.reader;

import com.example.domain.user.User;

public interface UserReader {
    User findByUid(String uid);
    User findById(Long id);
}
