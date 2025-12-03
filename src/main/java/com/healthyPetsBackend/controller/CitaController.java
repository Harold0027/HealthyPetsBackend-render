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

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public List<CitaResponseDTO> getAll() {
        return citaService.getAll();
    }

    @GetMapping("/{id}")
    public CitaResponseDTO getById(@PathVariable Long id) {
        return citaService.getById(id);
    }

    @PostMapping
    public CitaResponseDTO create(@RequestBody CitaCreateDTO dto) {
        return citaService.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        citaService.delete(id);
    }
}
