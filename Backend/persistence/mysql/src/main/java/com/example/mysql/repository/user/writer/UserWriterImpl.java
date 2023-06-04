package com.example.mysql.repository.user.writer;

import com.example.domain.user.User;
import com.example.mysql.mapper.user.UserMapper;
import com.example.mysql.repository.user.jpa.UserEntityRepository;
import com.example.mysql.repository.user.writer.UserWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserWriterImpl implements UserWriter {
    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;


    @Override
    public void save(User user) {

        userEntityRepository.save(userMapper.toEntity(user));
    }
}
