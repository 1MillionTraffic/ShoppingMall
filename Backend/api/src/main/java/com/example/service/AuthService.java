package com.example.service;

import com.example.config.oauth.OAuthConfig;
import com.example.domain.auth.Auth;
import com.example.domain.user.User;
import com.example.model.auth.Authentication;
import com.example.repository.auth.AuthReader;
import com.example.repository.auth.AuthWriter;
import com.example.repository.user.UserReader;
import com.example.repository.user.UserWriter;
import com.example.service.auth.OAuthConfigManager;
import com.example.httpClient.HttpClient;
import com.example.model.enums.OAuthProvider;
import com.example.response.auth.TokenRequestResponse;
import com.example.response.auth.UserInfoRequestResponse;
import com.example.service.auth.OAuthLoginProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    // region [Member Variables]
    private final OAuthConfigManager oAuthConfigManager;
    private final OAuthLoginProcessor oAuthLoginProcessor;
    private final UserReader userReader;
    private final UserWriter userWriter;

    private final AuthReader authReader;
    private final AuthWriter authWriter;

    // endregion


    public URI getLoginUrl(String providerName){
        OAuthProvider provider = Optional.ofNullable(OAuthProvider.getOAuthProvider(providerName)).orElseThrow();
        OAuthConfig oAuthConfig = oAuthConfigManager.getOAuthConfig(provider);

        return oAuthConfig.getLoginUrl();
    }

    @Transactional
    public void processOAuthLogin(HttpServletRequest request, HttpServletResponse response, String providerName, String code) throws AuthenticationException {
        OAuthProvider provider = Optional.ofNullable(OAuthProvider.getOAuthProvider(providerName)).orElseThrow();
        OAuthConfig oAuthConfig = oAuthConfigManager.getOAuthConfig(provider);

        Authentication authentication = oAuthLoginProcessor.process(oAuthConfig, code);

        Auth auth = authReader.findByUid(authentication.getId());

        if(auth == null){

        }

        User user = userReader.findByUid(authentication.getId());

        if(user ==  null){

        }

        oAuthLoginProcessor.saveState(request, response, authentication);
    }


}
