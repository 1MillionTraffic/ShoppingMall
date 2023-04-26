package com.example.repository.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader{
    private UserEntityRepository userEntityRepository;
}
