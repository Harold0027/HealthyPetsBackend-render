package com.healthyPetsBackend.dto;

import lombok.Data;

@Data
public class UserUpdateDTO {

    private String fullName;
    private String email;
    private String telefono;
    private String direccion;
    private String role;
}
