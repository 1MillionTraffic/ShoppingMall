package com.example.domain.user;

import com.example.domain.enums.UserGrade;
import com.example.domain.enums.UserType;
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
    private UserType userType;
    private UserGrade userGrade;

}
