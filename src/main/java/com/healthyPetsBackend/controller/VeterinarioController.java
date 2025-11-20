package com.healthyPetsBackend.controller;

import org.springframework.web.bind.annotation.*;

import com.healthyPetsBackend.model.Veterinario;
import com.healthyPetsBackend.service.VeterinarioService;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
@CrossOrigin("*")
public class VeterinarioController {

    private final VeterinarioService service;

    public VeterinarioController(VeterinarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Veterinario> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Veterinario getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Veterinario create(@RequestBody Veterinario veterinario) {
        return service.create(veterinario);
    }

    @PutMapping("/{id}")
    public Veterinario update(@PathVariable Long id, @RequestBody Veterinario veterinario) {
        return service.update(id, veterinario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
