package com.example.api.component.auth;

import com.example.domain.user.User;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

public interface AuthorizationHandler {
    User authorize(HttpServletRequest request) throws AuthenticationException;
}
