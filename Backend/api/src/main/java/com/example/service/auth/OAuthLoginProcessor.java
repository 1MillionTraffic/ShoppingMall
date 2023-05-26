package com.example.service.auth;

import com.example.config.oauth.OAuthConfig;
import com.example.model.auth.Authentication;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface OAuthLoginProcessor {
    Authentication process(OAuthConfig oAuthConfig, String code) throws AuthenticationException;
    void saveState(HttpServletRequest request, HttpServletResponse response, Authentication authentication);
}
