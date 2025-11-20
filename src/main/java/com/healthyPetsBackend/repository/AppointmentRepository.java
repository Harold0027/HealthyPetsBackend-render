package com.healthyPetsBackend.repository;

import com.healthyPetsBackend.model.Appointment;
import com.healthyPetsBackend.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // CORRECTO: el campo en Appointment se llama "mascota", no "pet"
    List<Appointment> findByMascota(Pet mascota);
}

