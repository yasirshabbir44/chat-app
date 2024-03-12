package com.example.demo.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Map to store username and their respective tokens
    private Map<String, String> userTokenMap = new HashMap<>();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Check if the user already has a token
        String token = userTokenMap.get(username);
        if (token == null) {
            // Generate a new random token
            token = generateJwtToken(username);
            // Store the token in the map
            userTokenMap.put(username, token);
        }

        // Return a User object with the generated token
        return new User(username, token, new ArrayList<>());
    }

    // Method to generate JWT token
    private String generateJwtToken(String username) {
        // Set token expiration time
        Date expiryDate = new Date(System.currentTimeMillis() + 864000000); // 10 days

        // Generate token
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, "YourSecretKey")
                .compact();
    }
}
