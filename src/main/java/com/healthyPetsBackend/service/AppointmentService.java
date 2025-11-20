package com.healthyPetsBackend.service;

import com.healthyPetsBackend.model.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getAll();

    Appointment getById(Long id);

    Appointment create(Appointment appointment);

    Appointment update(Long id, Appointment appointment);

    void delete(Long id);
}
