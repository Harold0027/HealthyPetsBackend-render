package com.healthyPetsBackend.service.impl;

import com.healthyPetsBackend.dto.PacienteCreateDTO;
import com.healthyPetsBackend.dto.PacienteResponseDTO;
import com.healthyPetsBackend.dto.PacienteUpdateDTO;
import com.healthyPetsBackend.dto.UserResponseDTO;
import com.healthyPetsBackend.model.Paciente;
import com.healthyPetsBackend.model.User;
import com.healthyPetsBackend.repository.PacienteRepository;
import com.healthyPetsBackend.service.PacienteService;
import com.healthyPetsBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository repo;

    @Autowired
    private UserService userService;

    @Override
    public PacienteResponseDTO create(PacienteCreateDTO dto) {

        UserResponseDTO dueñoDTO = userService.getById(dto.getDueñoId());
        if (dueñoDTO == null) throw new RuntimeException("Dueño no encontrado");

        Paciente p = new Paciente();
        User dueño = new User();
        dueño.setId(dueñoDTO.getId());
        dueño.setFullName(dueñoDTO.getFullName());
        p.setDueño(dueño);
        p.setNombre(dto.getNombre());
        p.setEspecie(dto.getEspecie());
        p.setRaza(dto.getRaza());
        p.setEdad(dto.getEdad());

        Paciente saved = repo.save(p);
        return mapToDTO(saved);
    }

    @Override
    public List<PacienteResponseDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public PacienteResponseDTO getById(Long id) {
        Paciente p = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        return mapToDTO(p);
    }

    @Override
    public PacienteResponseDTO update(Long id, PacienteUpdateDTO dto) {
        Paciente p = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        UserResponseDTO dueñoDTO = userService.getById(dto.getDueñoId());
        if (dueñoDTO == null) throw new RuntimeException("Dueño no encontrado");

        User dueño = new User();
        dueño.setId(dueñoDTO.getId());
        dueño.setFullName(dueñoDTO.getFullName());

        p.setDueño(dueño);
        p.setNombre(dto.getNombre());
        p.setEspecie(dto.getEspecie());
        p.setRaza(dto.getRaza());
        p.setEdad(dto.getEdad());

        Paciente updated = repo.save(p);
        return mapToDTO(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new RuntimeException("Paciente no encontrado");
        repo.deleteById(id);
    }

    @Override
    public Paciente findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    private PacienteResponseDTO mapToDTO(Paciente p) {
        PacienteResponseDTO dto = new PacienteResponseDTO();
        dto.setId(p.getId());
        dto.setDueñoId(p.getDueño().getId());
        dto.setNombre(p.getNombre());
        dto.setEspecie(p.getEspecie());
        dto.setRaza(p.getRaza());
        dto.setEdad(p.getEdad());
        dto.setDueñoNombre(p.getDueño().getFullName());
        return dto;
    }

    @Override
    public Paciente findEntityById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
    }

}
