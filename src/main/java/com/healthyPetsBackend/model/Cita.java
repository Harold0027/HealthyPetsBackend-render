package com.healthyPetsBackend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(
    name = "citas",
    uniqueConstraints = @UniqueConstraint(columnNames = {"veterinario_id", "fecha", "hora"})
)
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long paciente;       // id del paciente (mascota)
    private Long veterinarioId;  // id del veterinario

    private LocalDate fecha;
    private LocalTime hora;

    private String motivo;
}
