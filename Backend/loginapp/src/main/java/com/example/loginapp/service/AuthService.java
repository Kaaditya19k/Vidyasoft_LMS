package com.example.loginapp.service;

import com.example.loginapp.dto.AuthRequest;
import com.example.loginapp.dto.AuthResponse;
import com.example.loginapp.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(AuthRequest request);
}