package com.healthyPetsBackend.dto;

import lombok.Data;

@Data
public class PacienteCreateDTO {
    private Long duenoId;
    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;
}
