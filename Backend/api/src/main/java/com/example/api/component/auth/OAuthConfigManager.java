package com.example.api.component.auth;

import com.example.api.config.oauth.NaverOAuthConfig;
import com.example.api.config.oauth.OAuthConfig;
import com.example.api.model.enums.OAuthProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OAuthConfigManager {
    private final NaverOAuthConfig naverOAuthConfig;

    public OAuthConfig getOAuthConfig(OAuthProvider provider){
        switch(provider){
            case NAVER: return naverOAuthConfig;
            case KAKAO: ;
            case GOOGLE: ;
            default: return null;
        }
    }

}
