package com.example.api.config.oauth;

import com.example.api.model.enums.OAuthGrantType;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public abstract class OAuthConfig {
    // region [Member Variables]
    private final String DEFAULT_STATE = "some_state";
    private String clientId;

    private String clientSecret;

    private String redirectUri;

    private String loginUrl;

    private String tokenUrl;

    private String meUrl;

    private String providerName;

    private OAuthGrantType grantType = OAuthGrantType.AUTHORIZATION_CODE;

    private String state;
    // endregion

    // region [Constructors]
    public OAuthConfig(String clientId, String clientSecret, String redirectUri,
                       String loginUrl, String tokenUrl, String meUrl, String providerName){
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.loginUrl = loginUrl;
        this.tokenUrl = tokenUrl;
        this.meUrl = meUrl;
        this.providerName = providerName;

        this.state = this.DEFAULT_STATE;
    }
    // endregion

    public URI getLoginUrl(){
        return UriComponentsBuilder.newInstance()
                .uri(URI.create(loginUrl))
                .queryParam("response_type", "code")
                .queryParam("client_id", clientId)
                .queryParam("redirect_uri", redirectUri)
                .queryParam("state", state)
                .build()
                .toUri();
    }

    public URI getTokenUrl(String code){
        return UriComponentsBuilder.newInstance()
                .uri(URI.create(tokenUrl))
                .queryParam("grant_type", grantType.getGrantType())
                .queryParam("client_id", clientId)
                .queryParam("client_secret", clientSecret)
                .queryParam("code", code)
                .queryParam("state", state)
                .build()
                .toUri();
    }

    public URI getMeUrl(){
        return URI.create(meUrl);
    }

    public String getProviderName(){return this.providerName;}
}
