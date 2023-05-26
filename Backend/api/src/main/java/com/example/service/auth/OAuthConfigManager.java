package com.example.service.auth;

import com.example.config.oauth.NaverOAuthConfig;
import com.example.config.oauth.OAuthConfig;
import com.example.model.enums.OAuthProvider;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

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
