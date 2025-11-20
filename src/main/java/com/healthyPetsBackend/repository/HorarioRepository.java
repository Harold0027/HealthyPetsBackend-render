package com.healthyPetsBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthyPetsBackend.model.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
}
