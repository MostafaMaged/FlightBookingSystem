package com.instafly.task.models;

public class AuthenticationResponse {
    private final String Jwt;

    public AuthenticationResponse(String jwt) {
        Jwt = jwt;
    }

    public String getJwt() {
        return Jwt;
    }
}
