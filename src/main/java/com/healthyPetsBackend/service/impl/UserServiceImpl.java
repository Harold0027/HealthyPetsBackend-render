package com.healthyPetsBackend.service.impl;

import com.healthyPetsBackend.dto.UserCreateDTO;
import com.healthyPetsBackend.dto.UserResponseDTO;
import com.healthyPetsBackend.dto.UserUpdateDTO;
import com.healthyPetsBackend.model.Role;
import com.healthyPetsBackend.model.User;
import com.healthyPetsBackend.repository.UserRepository;
import com.healthyPetsBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // CREATE
    @Override
    public UserResponseDTO create(UserCreateDTO dto) {

        if (repo.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }

        User user = new User();
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setTelefono(dto.getTelefono());
        user.setDireccion(dto.getDireccion());

        // Si no mandan role → usar USER por defecto
        if (dto.getRole() == null) {
            user.setRole(Role.USER);
        } else {
            user.setRole(Role.valueOf(dto.getRole()));
        }

        User saved = repo.save(user);
        return mapToDTO(saved);
    }

    // GET ALL
    @Override
    public List<UserResponseDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // GET BY ID
    @Override
    public UserResponseDTO getById(Long id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return mapToDTO(user);
    }

    // UPDATE
    @Override
    public UserResponseDTO update(Long id, UserUpdateDTO dto) {

        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setTelefono(dto.getTelefono());
        user.setDireccion(dto.getDireccion());
        user.setRole(Role.valueOf(dto.getRole()));

        User updated = repo.save(user);
        return mapToDTO(updated);
    }

    // DELETE
    @Override
    public void delete(Long id) {

        if (!repo.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }

        repo.deleteById(id);
    }

    // Para AuthService
    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return repo.save(user);
    }


    private UserResponseDTO mapToDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole().name());
        dto.setTelefono(user.getTelefono());
        dto.setDireccion(user.getDireccion());

        return dto;
    }

    @Override
    public User findEntityById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

}
