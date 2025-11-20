package com.healthyPetsBackend.service;

import java.util.List;

import com.healthyPetsBackend.model.Horario;

public interface HorarioService {
    List<Horario> getAll();
    Horario getById(Long id);
    Horario create(Horario horario);
    Horario update(Long id, Horario horario);
    void delete(Long id);
}
