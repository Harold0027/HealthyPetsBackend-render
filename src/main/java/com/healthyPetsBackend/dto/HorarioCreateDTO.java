package com.healthyPetsBackend.dto;

import lombok.Data;

@Data
public class HorarioCreateDTO {
    private Long veterinarioId;
    private String dia;
    private String horaInicio;  // formato "HH:mm"
    private String horaFin;     // formato "HH:mm"
}
