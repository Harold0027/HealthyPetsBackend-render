package com.healthyPetsBackend.service.impl;

import org.springframework.stereotype.Service;

import com.healthyPetsBackend.model.Horario;
import com.healthyPetsBackend.repository.HorarioRepository;
import com.healthyPetsBackend.service.HorarioService;

import java.util.List;

@Service
public class HorarioServiceImpl implements HorarioService {

    private final HorarioRepository repository;

    public HorarioServiceImpl(HorarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Horario> getAll() {
        return repository.findAll();
    }

    @Override
    public Horario getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Horario create(Horario horario) {
        return repository.save(horario);
    }

    @Override
    public Horario update(Long id, Horario horario) {
        Horario found = getById(id);

        found.setFecha(horario.getFecha());
        found.setHoraInicio(horario.getHoraInicio());
        found.setHoraFin(horario.getHoraFin());
        found.setVeterinario(horario.getVeterinario());

        return repository.save(found);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
