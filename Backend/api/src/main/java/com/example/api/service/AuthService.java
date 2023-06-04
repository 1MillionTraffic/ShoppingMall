package com.example.api.service;

import com.example.api.config.oauth.OAuthConfig;
import com.example.domain.auth.Auth;
import com.example.domain.user.User;
import com.example.api.model.auth.Authentication;
import com.example.mysql.repository.auth.reader.AuthReader;
import com.example.mysql.repository.auth.writer.AuthWriter;
import com.example.mysql.repository.user.reader.UserReader;
import com.example.mysql.repository.user.writer.UserWriter;
import com.example.api.component.auth.OAuthConfigManager;
import com.example.api.model.enums.OAuthProvider;
import com.example.api.component.auth.OAuthLoginProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
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

    //@Transactional(value = "{authTransactionManager, userTransactionManager}")
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
