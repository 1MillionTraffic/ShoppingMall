package com.example.api.component.auth;

import com.example.api.model.auth.Authentication;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthStateManager {
    void saveState(HttpServletRequest request, HttpServletResponse response, Authentication auth);
    Authentication getAuth(HttpServletRequest request) throws AuthenticationException;
}
