package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@AllArgsConstructor
@Setter
public class JwtResponse {
    private String token;
    private String tokenType;
    private long expiresInMs;
    private Date expiryDate;

    // Getter methods for accessing the token and additional information
    public String getToken() {
        return token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public long getExpiresInMs() {
        return expiresInMs;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

}
