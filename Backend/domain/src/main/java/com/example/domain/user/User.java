package com.example.domain.user;

import com.example.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {
    private Long userId;
    private String uid;
    private String userName;
    private String email;

    public static User of(UserEntity entity){

        if(entity == null) return null;

        return User.builder()
                .userId(entity.getUserId())
                .uid(entity.getUid())
                .userName(entity.getUserName())
                .email(entity.getEmail())
                .build();
    }
}
