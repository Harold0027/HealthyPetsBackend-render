package com.healthypetsbackend.HealthyPetsBackend.service;

import com.healthypetsbackend.HealthyPetsBackend.dto.LoginRequest;
import com.healthypetsbackend.HealthyPetsBackend.dto.RegisterRequest;
import com.healthypetsbackend.HealthyPetsBackend.dto.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    AuthResponse register(RegisterRequest request);
}
