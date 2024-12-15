package com.mdaucodes.ecommerce.entity;

public class TokenResponse {

    private final String jwtToken;

    public TokenResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    @Override
    public String toString() {
        return "TokenResponse{" +
                "jwtToken='" + jwtToken + '\'' +
                '}';
    }
}
