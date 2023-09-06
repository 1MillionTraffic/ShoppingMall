package com.example.api.config.oauth;

import com.example.api.annotation.auth.resolver.AuthResolver;
import com.example.api.component.auth.AuthorizationHandlerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final AuthorizationHandlerFactory authorizationHandlerFactory;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new AuthResolver(authorizationHandlerFactory));
    }
}
