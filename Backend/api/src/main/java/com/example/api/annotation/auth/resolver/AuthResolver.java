package com.example.api.annotation.auth.resolver;

import com.example.api.annotation.auth.Auth;
import com.example.api.component.auth.AuthorizationHandler;
import com.example.api.component.auth.AuthorizationHandlerFactory;
import com.example.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class AuthResolver implements HandlerMethodArgumentResolver {
    private final AuthorizationHandlerFactory authorizationHandlerFactory;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(Auth.class) != null &&
                parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter
            , ModelAndViewContainer mavContainer
            , NativeWebRequest webRequest
            , WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest)webRequest.getNativeRequest();

        var annotation = Optional.ofNullable(parameter.getParameterAnnotation(Auth.class))
                                        .orElseThrow();
        var authorizationMode = annotation.authorizationMode();

        AuthorizationHandler authHandler = authorizationHandlerFactory.createHandler(authorizationMode);

        return authHandler.authorize(request);
    }
}
