package com.healthypetsbackend.HealthyPetsBackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;          // perro, gato, etc.
    private String breed;         // raza
    private int age;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;           // relación con usuario
}
