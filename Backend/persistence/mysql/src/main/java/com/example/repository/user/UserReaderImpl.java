package com.example.repository.user;

import com.example.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader{
    private final UserEntityRepository userEntityRepository;

    @Override
    public User findByUid(String uid) {
        return User.of(userEntityRepository.findByUid(uid).orElse(null));
    }
}
