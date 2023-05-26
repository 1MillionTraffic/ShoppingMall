package com.example.component.auth;

import com.example.model.auth.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthStateManager {
    void saveState(HttpServletRequest request, HttpServletResponse response, Authentication auth);
    Authentication getAuth(HttpServletRequest request);
}
