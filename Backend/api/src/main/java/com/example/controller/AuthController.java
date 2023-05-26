package com.example.controller;


import com.example.model.enums.OAuthProvider;
import com.example.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Optional;

@RequestMapping("/api/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping ("/oauth/{provider}")
    public ResponseEntity<?> oAuthLogin(@PathVariable("provider") String provider){
        HttpHeaders headers = new HttpHeaders();
        URI loginUrl = authService.getLoginUrl(provider);
        headers.setLocation(loginUrl);

        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/oauth/callback/{provider}")
    public ResponseEntity<?> oAuthLoginCallback(
            @PathVariable("provider") String provider,
            @RequestParam(name = "code") String code,
            @RequestParam(name = "state") String state,
            HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {

        authService.processOAuthLogin(request, response, provider, code);

        return null;
    }
}
