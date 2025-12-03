package com.healthyPetsBackend.service.impl;

import com.healthyPetsBackend.dto.CitaCreateDTO;
import com.healthyPetsBackend.dto.CitaResponseDTO;
import com.healthyPetsBackend.model.Cita;
import com.healthyPetsBackend.model.Paciente;
import com.healthyPetsBackend.repository.CitaRepository;
import com.healthyPetsBackend.repository.PacienteRepository;
import com.healthyPetsBackend.service.CitaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;
    private final PacienteRepository pacienteRepository;

    public CitaServiceImpl(CitaRepository citaRepository,
                           PacienteRepository pacienteRepository) {
        this.citaRepository = citaRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public CitaResponseDTO create(CitaCreateDTO dto) {

        // Validar paciente
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        // Validar que no exista otra cita para el paciente en la misma fecha y hora
        if (citaRepository.existsByPacienteAndFechaAndHora(dto.getPacienteId(), dto.getFecha(), dto.getHora())) {
            throw new RuntimeException("El paciente ya tiene una cita en esa fecha y hora.");
        }

        // Crear cita
        Cita cita = new Cita();
        cita.setPaciente(paciente.getId());
        cita.setFecha(dto.getFecha());
        cita.setHora(dto.getHora());
        cita.setMotivo(dto.getMotivo());

        Cita saved = citaRepository.save(cita);

        return mapToResponse(saved);
    }

    @Override
    public List<CitaResponseDTO> getAll() {
        return citaRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CitaResponseDTO getById(Long id) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        return mapToResponse(cita);
    }

    @Override
    public void delete(Long id) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        citaRepository.delete(cita);
    }

    private CitaResponseDTO mapToResponse(Cita cita) {
        CitaResponseDTO dto = new CitaResponseDTO();
        dto.setId(cita.getId());
        dto.setFecha(cita.getFecha());
        dto.setHora(cita.getHora());
        dto.setMotivo(cita.getMotivo());
        dto.setPacienteId(cita.getPaciente());

        // Obtener paciente y dueño
        Paciente paciente = pacienteRepository.findById(cita.getPaciente()).orElse(null);
        if (paciente != null) {
            dto.setPacienteNombre(paciente.getNombre());
            dto.setDuenoNombre(paciente.getDueño() != null ? paciente.getDueño().getFullName() : "Desconocido");
        } else {
            dto.setPacienteNombre("Desconocido");
            dto.setDuenoNombre("Desconocido");
        }

        return dto;
    }
}
