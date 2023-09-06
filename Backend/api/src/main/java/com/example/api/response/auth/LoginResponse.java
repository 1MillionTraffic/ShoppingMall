package com.example.api.response.auth;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {
    private Boolean login;
    private String username;
    private String email;
    private String userType;
    private String userGrade;
}
