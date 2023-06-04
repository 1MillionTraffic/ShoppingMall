package com.example.domain.auth;

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


}