package com.example.api.config.oauth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class NaverOAuthConfig extends OAuthConfig{

    public NaverOAuthConfig(
            @Value("${spring.oauth2.client.registration.naver.client-id}") String clientId,
            @Value("${spring.oauth2.client.registration.naver.client-secret}") String clientSecret,
            @Value("${spring.oauth2.client.registration.naver.redirect-uri}") String redirectUri,
            @Value("${spring.oauth2.client.provider.naver.login-url}") String loginUrl,
            @Value("${spring.oauth2.client.provider.naver.token-url}") String tokenUrl,
            @Value("${spring.oauth2.client.provider.naver.me-url}") String meUrl){
        super(clientId, clientSecret, redirectUri, loginUrl, tokenUrl, meUrl, "naver");
    }

}
