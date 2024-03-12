package com.example.demo.service;


import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
    boolean authenticate(String username, String password);
}
