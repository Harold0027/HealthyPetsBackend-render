package com.healthypetsbackend.HealthyPetsBackend.repository;

import com.healthypetsbackend.HealthyPetsBackend.model.Appointment;
import com.healthypetsbackend.HealthyPetsBackend.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPet(Pet pet);
}
