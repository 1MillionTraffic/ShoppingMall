package com.example.api.component.auth;

import com.example.api.model.auth.Authentication;
import com.example.domain.auth.Auth;
import com.example.mysql.repository.auth.reader.AuthReader;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AccessTokenAuthStateManager implements AuthStateManager{

    // region [Private Variable]
    private final AuthReader authReader;
    private final String COOKIE_KEY = "Authentication";

    private final Base64.Encoder encoder = Base64.getEncoder();

    private final Base64.Decoder decoder = Base64.getDecoder();
    // endregion

    //region [Private Methods]
    private String createPayload(Authentication authentication){
        return this.encoder
                .encodeToString(getPayloadData(authentication).getBytes());
    }

    private String getPayloadData(Authentication authentication){
        return String.format("{\"email\": \"%s\"}", authentication.getEmail());
    }

    private void setCookie(HttpServletResponse response, String payload){
        Cookie cookie = new Cookie(COOKIE_KEY, payload);
        System.out.println("payload :" + payload);
        response.addCookie(cookie);
    }

    private String getEmail(HttpServletRequest request) throws AuthenticationException {
        String payload = this.getPayload(request);
        String decodedPayload = new String(this.decoder.decode(payload));

        JsonParser jsonParser = new BasicJsonParser();
        Map<String, Object> jsonData = jsonParser.parseMap(decodedPayload);

        if (!jsonData.containsKey("email")) {
            throw new AuthenticationException();
        }

        return jsonData.get("email").toString();
    }

    private String getPayload(HttpServletRequest request){
        var cookies = request.getCookies();
        return Arrays.stream(cookies).filter(x -> x.getName().equals(COOKIE_KEY))
                .findAny()
                .orElseThrow()
                .getValue();
    }
    // endregion

    @Override
    public void saveState(HttpServletRequest request, HttpServletResponse response, Authentication auth) {
        String payload = this.createPayload(auth);
        this.setCookie(response, payload);
    }

    @Override
    public Authentication getAuth(HttpServletRequest request) throws AuthenticationException {
        String email = this.getEmail(request);
        Auth auth = authReader.findByEmail(email);

        return new Authentication(auth.getUid(), auth.getUserName(), auth.getEmail(), auth.getProvider());
    }
}
