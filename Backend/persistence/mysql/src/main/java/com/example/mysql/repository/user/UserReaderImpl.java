package com.example.mysql.repository.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {
    private UserEntityRepository userEntityRepository;
}
