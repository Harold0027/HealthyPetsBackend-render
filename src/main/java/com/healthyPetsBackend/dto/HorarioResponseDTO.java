package com.healthyPetsBackend.dto;

import lombok.Data;

@Data
public class HorarioResponseDTO {
    private Long id;
    private Long veterinarioId;
    private String veterinarioNombre;
    private String dia;
    private String horaInicio;
    private String horaFin;
}
