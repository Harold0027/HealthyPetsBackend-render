package com.healthyPetsBackend.service;

import com.healthyPetsBackend.dto.AuthResponse;
import com.healthyPetsBackend.dto.LoginRequest;
import com.healthyPetsBackend.dto.RegisterRequest;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    AuthResponse register(RegisterRequest request);
}
