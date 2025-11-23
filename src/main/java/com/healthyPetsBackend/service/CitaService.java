package com.healthyPetsBackend.service;

import com.healthyPetsBackend.dto.CitaCreateDTO;
import com.healthyPetsBackend.dto.CitaResponseDTO;
import java.util.List;

public interface CitaService {

    CitaResponseDTO create(CitaCreateDTO dto);

    List<CitaResponseDTO> getAll();

    CitaResponseDTO getById(Long id);

    void delete(Long id);
}
