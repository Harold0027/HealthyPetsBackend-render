package com.healthyPetsBackend.dto;

import lombok.Data;

@Data
public class PacienteUpdateDTO {
    private Long duenoId;
    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;
}
