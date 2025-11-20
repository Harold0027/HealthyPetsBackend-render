package com.healthyPetsBackend.service;

import java.util.List;

import com.healthyPetsBackend.model.Veterinario;

public interface VeterinarioService {
    List<Veterinario> getAll();
    Veterinario getById(Long id);
    Veterinario create(Veterinario veterinario);
    Veterinario update(Long id, Veterinario veterinario);
    void delete(Long id);
}
