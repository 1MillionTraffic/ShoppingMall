package com.example.api.controller;


import com.example.api.response.auth.LoginResponse;
import com.example.api.service.AuthService;
import com.example.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

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

        User user = authService.processOAuthLogin(request, response, provider, code);

        return new ResponseEntity<>(
                LoginResponse.builder()
                        .login(true)
                        .username(user.getUserName())
                        .userGrade(user.getUserGrade().toString())
                        .userType(user.getUserType().toString())
                        .build(),
                HttpStatus.OK
        );
    }
}
