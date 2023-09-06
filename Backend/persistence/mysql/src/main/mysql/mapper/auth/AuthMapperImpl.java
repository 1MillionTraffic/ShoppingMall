package com.example.mysql.mapper.auth;

import com.example.domain.auth.Auth;
import com.example.mysql.entity.auth.AuthEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T20:22:51+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class AuthMapperImpl implements AuthMapper {

    @Override
    public Auth toDomain(AuthEntity authEntity) {
        if ( authEntity == null ) {
            return null;
        }

        Auth.AuthBuilder auth = Auth.builder();

        auth.id( authEntity.getId() );
        auth.uid( authEntity.getUid() );
        auth.email( authEntity.getEmail() );
        auth.provider( authEntity.getProvider() );

        return auth.build();
    }

    @Override
    public AuthEntity toEntity(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        AuthEntity.AuthEntityBuilder authEntity = AuthEntity.builder();

        authEntity.id( auth.getId() );
        authEntity.uid( auth.getUid() );
        authEntity.email( auth.getEmail() );
        authEntity.provider( auth.getProvider() );

        return authEntity.build();
    }
}
