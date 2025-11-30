package com.healthyPetsBackend.service;

import com.healthyPetsBackend.dto.VeterinarioCreateDTO;
import com.healthyPetsBackend.dto.VeterinarioResponseDTO;
import com.healthyPetsBackend.dto.VeterinarioUpdateDTO;
import com.healthyPetsBackend.model.Veterinario;

import java.util.List;

public interface VeterinarioService {

    VeterinarioResponseDTO create(VeterinarioCreateDTO dto);

    List<VeterinarioResponseDTO> getAll();

    VeterinarioResponseDTO getById(Long id);

    VeterinarioResponseDTO update(Long id, VeterinarioUpdateDTO dto);

    void delete(Long id);

    Veterinario findEntityById(Long id);
}
