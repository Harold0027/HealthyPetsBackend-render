package com.healthyPetsBackend.repository;

import com.healthyPetsBackend.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.time.LocalTime;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    boolean existsByVeterinarioIdAndFechaAndHora(Long veterinarioId, LocalDate fecha, LocalTime hora);
}
