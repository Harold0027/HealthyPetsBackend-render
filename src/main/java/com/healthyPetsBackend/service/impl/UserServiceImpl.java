package com.healthyPetsBackend.service.impl;

import com.healthyPetsBackend.model.User;
import com.healthyPetsBackend.repository.UserRepository;
import com.healthyPetsBackend.service.UserService;
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

    @Override
    public User getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
