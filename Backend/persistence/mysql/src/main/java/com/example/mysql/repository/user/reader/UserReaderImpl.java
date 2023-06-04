package com.example.mysql.repository.user.reader;

import com.example.domain.user.User;
import com.example.mysql.entity.user.UserEntity;
import com.example.mysql.mapper.user.UserMapper;
import com.example.mysql.repository.user.jpa.UserEntityRepository;
import com.example.mysql.repository.user.reader.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {
    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public User findByUid(String uid) {
        UserEntity user  = userEntityRepository.findByUid(uid).orElse(null);
        return userMapper.toDomain(user);
    }
}
