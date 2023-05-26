package com.example.repository.auth;

import com.example.domain.auth.Auth;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class AuthReaderImpl implements AuthReader{
    private final AuthEntityRepository authEntityRepository;

    @Override
    public Auth findByUid(String uid) {
        return Auth.of(authEntityRepository.findByUid(uid).orElse(null));
    }
}
