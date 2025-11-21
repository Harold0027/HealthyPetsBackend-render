package com.healthyPetsBackend.service;

import com.healthyPetsBackend.dto.UserCreateDTO;
import com.healthyPetsBackend.dto.UserResponseDTO;
import com.healthyPetsBackend.dto.UserUpdateDTO;
import com.healthyPetsBackend.model.User;

import java.util.List;

public interface UserService {

    UserResponseDTO create(UserCreateDTO dto);

    List<UserResponseDTO> getAll();

    UserResponseDTO getById(Long id);

    UserResponseDTO update(Long id, UserUpdateDTO dto);

    void delete(Long id);

    User findByEmail(String email);

    User saveUser(User user);
}
