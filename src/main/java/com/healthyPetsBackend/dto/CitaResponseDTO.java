package com.healthyPetsBackend.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CitaResponseDTO {
    private Long id;
    private Long pacienteId;
    private String pacienteNombre;
    private String duenoNombre;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
}
