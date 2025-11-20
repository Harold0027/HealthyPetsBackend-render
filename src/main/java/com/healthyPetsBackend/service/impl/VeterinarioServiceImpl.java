package com.healthyPetsBackend.service.impl;

import org.springframework.stereotype.Service;

import com.healthyPetsBackend.model.Veterinario;
import com.healthyPetsBackend.repository.VeterinarioRepository;
import com.healthyPetsBackend.service.VeterinarioService;

import java.util.List;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository repository;

    public VeterinarioServiceImpl(VeterinarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Veterinario> getAll() {
        return repository.findAll();
    }

    @Override
    public Veterinario getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Veterinario create(Veterinario veterinario) {
        return repository.save(veterinario);
    }

    @Override
    public Veterinario update(Long id, Veterinario veterinario) {
        Veterinario found = getById(id);
        found.setNombre(veterinario.getNombre());
        found.setApellido(veterinario.getApellido());
        found.setEspecialidad(veterinario.getEspecialidad());
        found.setTelefono(veterinario.getTelefono());
        found.setCorreo(veterinario.getCorreo());
        found.setEstado(veterinario.isEstado());
        return repository.save(found);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
