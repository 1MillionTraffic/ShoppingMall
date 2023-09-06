package com.example.api.component.auth;

import com.example.api.model.enums.AuthorizationMode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorizationHandlerFactory {
    private final DefaultAuthorizationHandler defaultAuthorizationHandler;
    private final VendorAuthorizationHandler vendorAuthorizationHandler;

    public AuthorizationHandler createHandler(AuthorizationMode mode){
        switch (mode){
            case VENDOR_ONLY: return vendorAuthorizationHandler;
            case ADMIN_ONLY: ;
            default: return defaultAuthorizationHandler;
        }
    }
}
