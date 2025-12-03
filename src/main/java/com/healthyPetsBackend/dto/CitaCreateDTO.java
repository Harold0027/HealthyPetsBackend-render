package com.healthyPetsBackend.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CitaCreateDTO {
    private Long pacienteId;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
}
