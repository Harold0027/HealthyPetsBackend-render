package com.healthypetsbackend.HealthyPetsBackend.controller;

import com.healthypetsbackend.HealthyPetsBackend.dto.AuthResponse;
import com.healthypetsbackend.HealthyPetsBackend.dto.LoginRequest;
import com.healthypetsbackend.HealthyPetsBackend.dto.RegisterRequest;
import com.healthypetsbackend.HealthyPetsBackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }
}
