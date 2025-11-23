package com.healthyPetsBackend.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CitaResponseDTO {
    private Long id;
    private Long paciente;
    private Long mascota_id;
    private Long veterinario_id;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
}
