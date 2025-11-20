package com.healthyPetsBackend.service.impl;

import com.healthyPetsBackend.model.Appointment;
import com.healthyPetsBackend.repository.AppointmentRepository;
import com.healthyPetsBackend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Override
    public List<Appointment> getAll() {
        return repository.findAll();
    }

    @Override
    public Appointment getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Appointment create(Appointment appointment) {
        return repository.save(appointment);
    }

    @Override
    public Appointment update(Long id, Appointment appointment) {
        Appointment existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        existing.setDescripcion(appointment.getDescripcion());
        existing.setFechaCita(appointment.getFechaCita());
        existing.setHoraCita(appointment.getHoraCita());
        existing.setEstado(appointment.getEstado());
        existing.setMascota(appointment.getMascota());
        existing.setUsuario(appointment.getUsuario());
        existing.setVeterinario(appointment.getVeterinario());
        existing.setHorario(appointment.getHorario());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
