package com.example.api.component.auth;

import com.example.api.model.auth.Authentication;
import com.example.domain.user.User;
import com.example.mysql.repository.user.reader.UserReader;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultAuthorizationHandler implements AuthorizationHandler{
    private final UserReader userReader;
    private final AuthStateManager authStateManager;


    protected User findUser(HttpServletRequest request) throws AuthenticationException {
        Authentication authentication = authStateManager.getAuth(request);
        return this.userReader.findByUid(authentication.getId());
    }

    @Override
    public User authorize(HttpServletRequest request) throws AuthenticationException {
        return Optional.ofNullable(findUser(request)).orElseThrow();
    }
}
