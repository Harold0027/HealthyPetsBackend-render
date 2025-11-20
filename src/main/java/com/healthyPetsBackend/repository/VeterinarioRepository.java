package com.healthyPetsBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthyPetsBackend.model.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}
