package com.healthyPetsBackend.service.impl;

import com.healthyPetsBackend.dto.VeterinarioCreateDTO;
import com.healthyPetsBackend.dto.VeterinarioResponseDTO;
import com.healthyPetsBackend.dto.VeterinarioUpdateDTO;
import com.healthyPetsBackend.model.Veterinario;
import com.healthyPetsBackend.repository.VeterinarioRepository;
import com.healthyPetsBackend.service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    @Autowired
    private VeterinarioRepository repo;

    @Override
    public VeterinarioResponseDTO create(VeterinarioCreateDTO dto) {
        if (repo.existsByCorreo(dto.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado");
        }

        Veterinario vet = new Veterinario();
        vet.setNombre(dto.getNombre());
        vet.setEspecialidad(dto.getEspecialidad());
        vet.setCorreo(dto.getCorreo());
        vet.setTelefono(dto.getTelefono());
        vet.setDireccion(dto.getDireccion());
        vet.setInformacion(dto.getInformacion());
        vet.setImagenUrl(dto.getImagenUrl());

        Veterinario saved = repo.save(vet);
        return mapToDTO(saved);
    }

    @Override
    public List<VeterinarioResponseDTO> getAll() {
        return repo.findAll().stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public VeterinarioResponseDTO getById(Long id) {
        Veterinario vet = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));
        return mapToDTO(vet);
    }

    @Override
    public VeterinarioResponseDTO update(Long id, VeterinarioUpdateDTO dto) {
        Veterinario vet = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));

        vet.setNombre(dto.getNombre());
        vet.setEspecialidad(dto.getEspecialidad());
        vet.setCorreo(dto.getCorreo());
        vet.setTelefono(dto.getTelefono());
        vet.setDireccion(dto.getDireccion());
        vet.setInformacion(dto.getInformacion());
        vet.setImagenUrl(dto.getImagenUrl());

        Veterinario updated = repo.save(vet);
        return mapToDTO(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Veterinario no encontrado");
        }
        repo.deleteById(id);
    }

    private VeterinarioResponseDTO mapToDTO(Veterinario vet) {
        VeterinarioResponseDTO dto = new VeterinarioResponseDTO();
        dto.setId(vet.getId());
        dto.setNombre(vet.getNombre());
        dto.setEspecialidad(vet.getEspecialidad());
        dto.setCorreo(vet.getCorreo());
        dto.setTelefono(vet.getTelefono());
        dto.setDireccion(vet.getDireccion());
        dto.setInformacion(vet.getInformacion());
        dto.setImagenUrl(vet.getImagenUrl());
        return dto;
    }

    @Override
    public Veterinario findEntityById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));
    }
}
