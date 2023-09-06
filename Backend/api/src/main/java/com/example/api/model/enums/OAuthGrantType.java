package com.example.api.model.enums;

public enum OAuthGrantType {
    AUTHORIZATION_CODE("authorization_code"),
    REFRESH_TOKEN("refresh_token"),
    DELETE("delete");

    private final String grantType;

    OAuthGrantType(String grantType){
        this.grantType = grantType;
    }

    public String getGrantType() {return this.grantType;}
}
