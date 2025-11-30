package com.healthyPetsBackend.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CitaCreateDTO {
    private Long pacienteId;
    private Long veterinarioId;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
}
