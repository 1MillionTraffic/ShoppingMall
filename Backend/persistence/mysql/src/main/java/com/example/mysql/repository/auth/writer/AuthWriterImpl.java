package com.example.mysql.repository.auth.writer;

import com.example.domain.auth.Auth;
import com.example.mysql.entity.auth.AuthEntity;
import com.example.mysql.mapper.auth.AuthMapper;
import com.example.mysql.repository.auth.jpa.AuthEntityRepository;
import com.example.mysql.repository.auth.writer.AuthWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AuthWriterImpl implements AuthWriter {
    private final AuthEntityRepository authEntityRepository;
    private final AuthMapper authMapper = AuthMapper.INSTANCE;

    @Override
    public void save(Auth auth) {
        AuthEntity authEntity = authMapper.toEntity(auth);
        authEntityRepository.save(authEntity);
    }
}
