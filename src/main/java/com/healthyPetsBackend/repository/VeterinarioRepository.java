package com.healthyPetsBackend.repository;

import com.healthyPetsBackend.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {

    boolean existsByCorreo(String correo);
}
