package com.healthyPetsBackend.dto;

import lombok.Data;

@Data
public class VeterinarioResponseDTO {
    private Long id;
    private String nombre;
    private String especialidad;
    private String correo;
    private String telefono;
    private String direccion;
}
