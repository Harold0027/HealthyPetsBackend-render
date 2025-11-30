package com.healthyPetsBackend.service;

import com.healthyPetsBackend.dto.PacienteCreateDTO;
import com.healthyPetsBackend.dto.PacienteResponseDTO;
import com.healthyPetsBackend.dto.PacienteUpdateDTO;
import com.healthyPetsBackend.model.Paciente;

import java.util.List;

public interface PacienteService {
    PacienteResponseDTO create(PacienteCreateDTO dto);
    List<PacienteResponseDTO> getAll();
    PacienteResponseDTO getById(Long id);
    PacienteResponseDTO update(Long id, PacienteUpdateDTO dto);
    void delete(Long id);
    Paciente findById(Long id);       // retorna null si no existe
    Paciente findEntityById(Long id); // retorna entidad o lanza excepción
}
