package com.example.component.auth;

import com.example.model.auth.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessTokenAuthStateManager implements AuthStateManager{
    @Override
    public void saveState(HttpServletRequest request, HttpServletResponse response, Authentication auth) {

    }

    @Override
    public Authentication getAuth(HttpServletRequest request) {
        return null;
    }
}
