package com.kuama.kinitializer.modules.authentication.dtos;

public class JwtTokenDto {

    String Token;

    String RefreshToken;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getRefreshToken() {
        return RefreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        RefreshToken = refreshToken;
    }
}
