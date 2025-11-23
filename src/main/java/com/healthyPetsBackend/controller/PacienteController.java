package com.healthyPetsBackend.controller;

import com.healthyPetsBackend.dto.PacienteCreateDTO;
import com.healthyPetsBackend.dto.PacienteResponseDTO;
import com.healthyPetsBackend.dto.PacienteUpdateDTO;
import com.healthyPetsBackend.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    public List<PacienteResponseDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PacienteResponseDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public PacienteResponseDTO create(@RequestBody PacienteCreateDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public PacienteResponseDTO update(@PathVariable Long id, @RequestBody PacienteUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
