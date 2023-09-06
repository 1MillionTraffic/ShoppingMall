package com.example.api.annotation.auth;

import com.example.api.model.enums.AuthorizationMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
    AuthorizationMode authorizationMode() default AuthorizationMode.DEFAULT;
}
