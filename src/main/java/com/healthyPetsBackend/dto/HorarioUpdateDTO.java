package com.healthyPetsBackend.dto;

import lombok.Data;

@Data
public class HorarioUpdateDTO {
    private Long veterinarioId;
    private String dia;
    private String horaInicio;
    private String horaFin;
}
