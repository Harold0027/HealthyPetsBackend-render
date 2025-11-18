package com.healthypetsbackend.HealthyPetsBackend.service;

import com.healthypetsbackend.HealthyPetsBackend.model.Appointment;
import com.healthypetsbackend.HealthyPetsBackend.model.Pet;

import java.util.List;

public interface AppointmentService {

    Appointment save(Appointment appointment);

    List<Appointment> getByPet(Pet pet);

    Appointment getById(Long id);

    void delete(Long id);
}
