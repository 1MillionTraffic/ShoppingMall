package com.example.mysql.mapper.user;

import com.example.domain.user.User;
import com.example.mysql.entity.user.UserEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T20:22:52+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User toDomain(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.userId( userEntity.getUserId() );
        user.uid( userEntity.getUid() );
        user.userName( userEntity.getUserName() );
        user.email( userEntity.getEmail() );

        return user.build();
    }

    @Override
    public UserEntity toEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.userId( user.getUserId() );
        userEntity.uid( user.getUid() );
        userEntity.userName( user.getUserName() );
        userEntity.email( user.getEmail() );

        return userEntity.build();
    }
}
