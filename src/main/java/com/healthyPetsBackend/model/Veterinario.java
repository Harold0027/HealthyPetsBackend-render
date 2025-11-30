package com.healthyPetsBackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "veterinarios")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String especialidad;

    @Column(unique = true)
    private String correo;

    private String telefono;

    private String direccion;

    // Nuevos campos
    @Column(length = 1000)
    private String informacion;

    private String imagenUrl;
}

