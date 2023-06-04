package com.example.api.component.auth;

import com.example.api.config.oauth.OAuthConfig;
import com.example.api.model.auth.Authentication;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface OAuthLoginProcessor {
    Authentication process(OAuthConfig oAuthConfig, String code) throws AuthenticationException;
    void saveState(HttpServletRequest request, HttpServletResponse response, Authentication authentication);
}
