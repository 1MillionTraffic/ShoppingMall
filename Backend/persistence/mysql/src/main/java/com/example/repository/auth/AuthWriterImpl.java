package com.example.repository.auth;

import com.example.domain.auth.Auth;
import com.example.entity.auth.AuthEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AuthWriterImpl implements AuthWriter{
    private final AuthEntityRepository authEntityRepository;

    @Override
    public void save(Auth auth) {
        authEntityRepository.save(AuthEntity.of(auth));
    }
}
