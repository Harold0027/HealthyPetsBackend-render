package com.healthyPetsBackend.dto;

import lombok.Data;

@Data
public class PacienteCreateDTO {
    private Long dueñoId;
    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;
}
