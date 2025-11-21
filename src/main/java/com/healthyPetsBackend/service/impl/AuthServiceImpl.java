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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(LoginRequest request) {

        // 1. Autenticar en Spring Security
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // 2. Obtener usuario real desde la BD
        User user = userService.findByEmail(request.getEmail());

        // 3. Generar token correcto
        String token = jwtProvider.generateToken(user);

        return new AuthResponse(token, user.getEmail(), "ROLE_" + user.getRole().name());
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

        userService.saveUser(user);

        String token = jwtProvider.generateToken(user);

        return new AuthResponse(token, user.getEmail(), "ROLE_" + user.getRole().name());
    }
}
