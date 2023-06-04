package com.example.api.response.auth;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoRequestResponse implements Serializable {
    private String resultCode;
    private String message;
    private Response response;

    public String getId(){return response.getId();}
    public String getEmail(){return response.getEmail();}

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private class Response{
        private String id;
        private String nickName;
        private String email;
    }
}

