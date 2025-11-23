package com.healthyPetsBackend.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CitaCreateDTO {
    private Long paciente;
    private Long mascota_id;
    private Long veterinario_id;

    private LocalDate fecha; // "2025-03-01"
    private LocalTime hora;  // "15:00"

    private String motivo;
}
