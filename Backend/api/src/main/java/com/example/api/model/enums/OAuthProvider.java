package com.example.api.model.enums;

public enum OAuthProvider {
    NAVER("naver"),
    KAKAO("kakao"),
    GOOGLE("google");
    private final String providerName;

    OAuthProvider(String providerName){
        this.providerName = providerName;
    }

    public String getProviderName(){
        return this.providerName;
    }

    public static OAuthProvider getOAuthProvider(String providerName){
        for(OAuthProvider provider : OAuthProvider.values()){
            if(provider.isProviderName(providerName)){
                return provider;
            }
        }

        return null;
    }

    private boolean isProviderName(String providerName){
        return this.getProviderName().equals(providerName)
                || this.getProviderName().equals(providerName.toUpperCase())
                || this.getProviderName().equals(providerName.toLowerCase());
    }
}
