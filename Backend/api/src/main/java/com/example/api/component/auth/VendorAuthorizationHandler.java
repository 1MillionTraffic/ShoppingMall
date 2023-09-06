package com.example.api.component.auth;

import com.example.domain.enums.UserType;
import com.example.domain.user.User;
import com.example.mysql.repository.user.reader.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

@Component
public class VendorAuthorizationHandler extends DefaultAuthorizationHandler{

    public VendorAuthorizationHandler(UserReader userReader, AuthStateManager stateManager){
        super(userReader, stateManager);
    }


    @Override
    public User authorize(HttpServletRequest request) throws AuthenticationException {
        User user = super.authorize(request);
        UserType userType = user.getUserType();

        if(userType != UserType.VENDOR && userType != UserType.ADMIN){
            throw new AuthenticationException();
        }

        return user;
    }
}
