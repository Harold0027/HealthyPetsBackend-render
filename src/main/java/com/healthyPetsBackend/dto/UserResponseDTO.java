package com.healthyPetsBackend.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String fullName;
    private String email;
    private String role;
    private String telefono;
    private String direccion;
}
