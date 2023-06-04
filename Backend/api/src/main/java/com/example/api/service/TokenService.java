package com.example.api.service;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TokenService {



    /*private String issueToken(String data, String tokenPrefix, int cookieExpire) {
        if(Objects.isNull(data)) {
            return null;
        }

        String expireString = String.valueOf((System.currentTimeMillis() + cookieExpire * 1000L));
        String rawToken = String.join(delimiter, tokenPrefix, expireString, data);
        String encryptedToken = AES256Util.encrypt(tokenKey, rawToken);

        if (Objects.isNull(encryptedToken)) {
            return null;
        }

        return encryptedToken;
    }*/

}
