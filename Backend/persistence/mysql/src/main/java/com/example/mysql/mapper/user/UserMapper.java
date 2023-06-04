package com.example.mysql.mapper.user;

import com.example.domain.user.User;
import com.example.mysql.entity.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User toDomain(UserEntity userEntity);
    UserEntity toEntity(User user);
}
