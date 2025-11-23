package com.healthyPetsBackend.controller;

import com.healthyPetsBackend.dto.VeterinarioCreateDTO;
import com.healthyPetsBackend.dto.VeterinarioResponseDTO;
import com.healthyPetsBackend.dto.VeterinarioUpdateDTO;
import com.healthyPetsBackend.service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarios")
@CrossOrigin(origins = "*")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping
    public List<VeterinarioResponseDTO> getAll() {
        return veterinarioService.getAll();
    }

    @GetMapping("/{id}")
    public VeterinarioResponseDTO getById(@PathVariable Long id) {
        return veterinarioService.getById(id);
    }

    @PostMapping
    public VeterinarioResponseDTO create(@RequestBody VeterinarioCreateDTO dto) {
        return veterinarioService.create(dto);
    }

    @PutMapping("/{id}")
    public VeterinarioResponseDTO update(@PathVariable Long id, @RequestBody VeterinarioUpdateDTO dto) {
        return veterinarioService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        veterinarioService.delete(id);
    }
}
