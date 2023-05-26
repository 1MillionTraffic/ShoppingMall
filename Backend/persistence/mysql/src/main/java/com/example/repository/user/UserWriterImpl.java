package com.example.repository.user;

import com.example.domain.user.User;
import com.example.entity.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserWriterImpl implements UserWriter{
    private final UserEntityRepository userEntityRepository;


    @Override
    public void save(User user) {
        userEntityRepository.save(UserEntity.of(user));
    }
}
