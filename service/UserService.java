package com.healthypetsbackend.HealthyPetsBackend.service;

import com.healthypetsbackend.HealthyPetsBackend.model.User;

public interface UserService {
    User save(User user);
    User findByEmail(String email);
}
