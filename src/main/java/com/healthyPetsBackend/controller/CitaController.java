package com.healthyPetsBackend.controller;

import com.healthyPetsBackend.dto.CitaCreateDTO;
import com.healthyPetsBackend.dto.CitaResponseDTO;
import com.healthyPetsBackend.service.CitaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    private final CitaService service;

    public CitaController(CitaService service) {
        this.service = service;
    }

    // Obtener todas las citas
    @GetMapping
    public List<CitaResponseDTO> getAll() {
        return service.getAll();
    }

    // Obtener una cita por ID
    @GetMapping("/{id}")
    public CitaResponseDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // Crear una nueva cita
    @PostMapping
    public CitaResponseDTO create(@RequestBody CitaCreateDTO dto) {
        return service.create(dto);
    }

    // Eliminar una cita por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
