package com.healthypetsbackend.HealthyPetsBackend.service.impl;

import com.healthypetsbackend.HealthyPetsBackend.model.User;
import com.healthypetsbackend.HealthyPetsBackend.repository.UserRepository;
import com.healthypetsbackend.HealthyPetsBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public User save(User user) {
        return repo.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }
}
