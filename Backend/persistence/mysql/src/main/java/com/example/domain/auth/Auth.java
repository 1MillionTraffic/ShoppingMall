package com.example.domain.auth;

import com.example.entity.auth.AuthEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Auth {
    private Long id;
    private String uid;
    private String email;
    private String provider;

    public static Auth of(AuthEntity entity){

        if (entity == null) return null;

        return Auth.builder()
                .id(entity.getId())
                .uid(entity.getUid())
                .email(entity.getEmail())
                .provider(entity.getProvider())
                .build();
    }
}
