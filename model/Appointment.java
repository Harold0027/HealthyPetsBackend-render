package com.healthypetsbackend.HealthyPetsBackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
