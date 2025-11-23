package com.healthyPetsBackend.service;

import com.healthyPetsBackend.dto.HorarioCreateDTO;
import com.healthyPetsBackend.dto.HorarioResponseDTO;
import com.healthyPetsBackend.dto.HorarioUpdateDTO;
import com.healthyPetsBackend.model.Horario;

import java.util.List;

public interface HorarioService {

    HorarioResponseDTO create(HorarioCreateDTO dto);

    List<HorarioResponseDTO> getAll();

    HorarioResponseDTO getById(Long id);

    HorarioResponseDTO update(Long id, HorarioUpdateDTO dto);

    void delete(Long id);

    Horario findById(Long id);

    boolean isAvailable(Long veterinarioId, String dia, String hora);

    List<Horario> findByVeterinarioId(Long veterinarioId);
}
