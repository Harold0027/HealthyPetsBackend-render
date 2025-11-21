package com.healthyPetsBackend.controller;

import com.healthyPetsBackend.dto.UserCreateDTO;
import com.healthyPetsBackend.dto.UserResponseDTO;
import com.healthyPetsBackend.dto.UserUpdateDTO;
import com.healthyPetsBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponseDTO> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponseDTO getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public UserResponseDTO create(@RequestBody UserCreateDTO dto) {
        return userService.create(dto);
    }

    @PutMapping("/{id}")
    public UserResponseDTO update(@PathVariable Long id, @RequestBody UserUpdateDTO dto) {
        return userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
