package com.example.mysql.repository.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserWriterImpl implements UserWriter {
    private UserEntityRepository userEntityRepository;

}
