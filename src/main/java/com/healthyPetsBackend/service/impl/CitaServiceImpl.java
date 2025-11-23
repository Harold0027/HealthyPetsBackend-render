package com.healthyPetsBackend.service.impl;

import com.healthyPetsBackend.dto.CitaCreateDTO;
import com.healthyPetsBackend.dto.CitaResponseDTO;
import com.healthyPetsBackend.model.Cita;
import com.healthyPetsBackend.repository.CitaRepository;
import com.healthyPetsBackend.service.CitaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository repository;

    public CitaServiceImpl(CitaRepository repository) {
        this.repository = repository;
    }

    @Override
    public CitaResponseDTO create(CitaCreateDTO dto) {
        // Validar disponibilidad
        if (repository.existsByVeterinarioIdAndFechaAndHora(dto.getVeterinario_id(), dto.getFecha(), dto.getHora())) {
            throw new RuntimeException("El veterinario ya tiene una cita asignada a esa hora.");
        }

        Cita cita = new Cita();
        cita.setPaciente(dto.getPaciente());
        cita.setMascota_id(dto.getMascota_id());
        cita.setVeterinarioId(dto.getVeterinario_id());
        cita.setFecha(dto.getFecha());
        cita.setHora(dto.getHora());
        cita.setMotivo(dto.getMotivo());

        return mapToResponse(repository.save(cita));
    }

    @Override
    public List<CitaResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CitaResponseDTO getById(Long id) {
        Cita cita = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        return mapToResponse(cita);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private CitaResponseDTO mapToResponse(Cita cita) {
        CitaResponseDTO dto = new CitaResponseDTO();
        dto.setId(cita.getId());
        dto.setPaciente(cita.getPaciente());
        dto.setMascota_id(cita.getMascota_id());
        dto.setVeterinario_id(cita.getVeterinarioId());
        dto.setFecha(cita.getFecha());
        dto.setHora(cita.getHora());
        dto.setMotivo(cita.getMotivo());
        return dto;
    }
}
