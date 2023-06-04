package com.example.mysql.repository.auth.reader;

import com.example.domain.auth.Auth;
import com.example.mysql.entity.auth.AuthEntity;
import com.example.mysql.mapper.auth.AuthMapper;
import com.example.mysql.repository.auth.jpa.AuthEntityRepository;
import com.example.mysql.repository.auth.reader.AuthReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class AuthReaderImpl implements AuthReader {
    private final AuthEntityRepository authEntityRepository;
    private final AuthMapper authMapper = AuthMapper.INSTANCE;


    @Override
    public Auth findByUid(String uid) {
        AuthEntity authEntity = authEntityRepository.findByUid(uid).orElse(null);

        return authMapper.toDomain(authEntity);
    }

    @Override
    public Auth findByEmail(String email){
        AuthEntity authEntity = authEntityRepository.findByEmail(email).orElse(null);

        return authMapper.toDomain(authEntity);
    }
}
