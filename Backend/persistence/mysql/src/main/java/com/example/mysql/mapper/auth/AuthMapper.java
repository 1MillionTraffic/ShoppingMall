package com.example.mysql.mapper.auth;


import com.example.domain.auth.Auth;
import com.example.mysql.entity.auth.AuthEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthMapper {
    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);
    Auth toDomain(AuthEntity authEntity);
    AuthEntity toEntity(Auth auth);
}
