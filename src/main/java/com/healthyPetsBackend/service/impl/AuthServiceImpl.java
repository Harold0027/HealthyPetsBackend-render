package com.healthyPetsBackend.service.impl;

import com.healthyPetsBackend.dto.AuthResponse;
import com.healthyPetsBackend.dto.LoginRequest;
import com.healthyPetsBackend.dto.RegisterRequest;
import com.healthyPetsBackend.model.Role;
import com.healthyPetsBackend.model.User;
import com.healthyPetsBackend.security.jwt.JwtProvider;
import com.healthyPetsBackend.service.AuthService;
import com.healthyPetsBackend.service.UserService;
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
        if (user == null) {
            throw new RuntimeException("Email incorrecto");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtProvider.generateToken(user);
        return new AuthResponse(token, user.getEmail(), user.getRole().name());
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

        // Asigna rol por defecto
        user.setRole(Role.USER);

        userService.save(user);

        String token = jwtProvider.generateToken(user);
        return new AuthResponse(token, user.getEmail(), user.getRole().name());
    }
}
