package com.healthypetsbackend.HealthyPetsBackend.service.impl;

import com.healthypetsbackend.HealthyPetsBackend.model.Appointment;
import com.healthypetsbackend.HealthyPetsBackend.model.Pet;
import com.healthypetsbackend.HealthyPetsBackend.repository.AppointmentRepository;
import com.healthypetsbackend.HealthyPetsBackend.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentServiceImpl(AppointmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        return repository.save(appointment);
    }

    @Override
    public List<Appointment> getByPet(Pet pet) {
        return repository.findByPet(pet);
    }

    @Override
    public Appointment getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
