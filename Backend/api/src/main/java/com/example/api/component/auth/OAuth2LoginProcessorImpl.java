package com.example.api.component.auth;

import com.example.api.config.oauth.OAuthConfig;
import com.example.api.component.httpClient.HttpClient;
import com.example.api.model.auth.Authentication;
import com.example.api.response.auth.TokenRequestResponse;
import com.example.api.response.auth.UserInfoRequestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class OAuth2LoginProcessorImpl implements OAuthLoginProcessor {

    // region [Member Variables]
    private final HttpClient httpClient;
    private final AuthStateManager authStateManager;

    // endregion

    // region [Private Methods]
    private TokenRequestResponse getTokenResponse(OAuthConfig oAuthConfig, String code) throws AuthenticationException {

        String tokenUrl = oAuthConfig.getTokenUrl(code).toString();
        TokenRequestResponse tokenRequestResponse = httpClient.request(tokenUrl, TokenRequestResponse.class);

        if(tokenRequestResponse.getError() != null){
            throw new AuthenticationException();
        }

        return tokenRequestResponse;
    }

    private UserInfoRequestResponse getUserInfo(OAuthConfig oAuthConfig, String accessToken) throws AuthenticationException {
        String meUrl = oAuthConfig.getMeUrl().toString();
        Map<String, String> headers = new HashMap<>(){{ put("Authorization", "Bearer " + accessToken); }};
        UserInfoRequestResponse userInfo = httpClient.request(meUrl, UserInfoRequestResponse.class, headers);

        if(userInfo == null){
            throw new AuthenticationException();
        }

        return userInfo;
    }

    // endregion

    @Override
    public Authentication process(OAuthConfig oAuthConfig, String code) throws AuthenticationException {

        TokenRequestResponse tokenRequestResponse = this.getTokenResponse(oAuthConfig, code);

        UserInfoRequestResponse userInfo = this.getUserInfo(oAuthConfig, tokenRequestResponse.getAccess_token());

        return new Authentication(userInfo.getId(), userInfo.getUsername(), userInfo.getEmail(), oAuthConfig.getProviderName());
    }

    @Override
    public void saveState(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        authStateManager.saveState(request, response, authentication);
    }



}
