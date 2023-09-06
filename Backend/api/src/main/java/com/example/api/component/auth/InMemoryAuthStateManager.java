package com.example.api.component.auth;

import com.example.api.model.auth.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryAuthStateManager implements AuthStateManager{
    private final Map<String, Authentication> sessionStore = new ConcurrentHashMap<>();
    @Override
    public void saveState(HttpServletRequest request, HttpServletResponse response, Authentication auth) {
        sessionStore.put(auth.getId(), auth);
        Cookie cookie = new Cookie("Authentication", "Bearer " + auth.getId());
        response.addCookie(cookie);
    }

    @Override
    public Authentication getAuth(HttpServletRequest request) {
        String key = Arrays.stream(request.getCookies()).filter(x -> x.getName().equals("Authentication"))
                .findAny()
                .orElseThrow()
                .getValue()
                .replace("Bearer ", "");

        return sessionStore.get(key);
    }
}
