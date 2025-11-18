package com.healthypetsbackend.HealthyPetsBackend.service.impl;

import com.healthypetsbackend.HealthyPetsBackend.dto.AuthResponse;
import com.healthypetsbackend.HealthyPetsBackend.dto.LoginRequest;
import com.healthypetsbackend.HealthyPetsBackend.dto.RegisterRequest;
import com.healthypetsbackend.HealthyPetsBackend.model.Role;
import com.healthypetsbackend.HealthyPetsBackend.model.User;
import com.healthypetsbackend.HealthyPetsBackend.security.jwt.JwtProvider;
import com.healthypetsbackend.HealthyPetsBackend.service.AuthService;
import com.healthypetsbackend.HealthyPetsBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = userService.findByEmail(request.getEmail());
        if (user == null) throw new RuntimeException("Email incorrecto");

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtProvider.generateToken(user);
        return new AuthResponse(token, user.getRole().name());
    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (userService.findByEmail(request.getEmail()) != null) {
            throw new RuntimeException("El email ya está registrado");
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        userService.save(user);

        String token = jwtProvider.generateToken(user);
        return new AuthResponse(token, user.getRole().name());
    }
}
