package com.healthyPetsBackend.dto;

import lombok.Data;

@Data
public class UserCreateDTO {

    private String fullName;
    private String email;
    private String password;
    private String telefono;
    private String direccion;
    private String role;
}
