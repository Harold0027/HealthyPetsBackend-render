package com.healthyPetsBackend.controller;

import org.springframework.web.bind.annotation.*;

import com.healthyPetsBackend.model.Horario;
import com.healthyPetsBackend.service.HorarioService;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
@CrossOrigin("*")
public class HorarioController {

    private final HorarioService service;

    public HorarioController(HorarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Horario> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Horario getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Horario create(@RequestBody Horario horario) {
        return service.create(horario);
    }

    @PutMapping("/{id}")
    public Horario update(@PathVariable Long id, @RequestBody Horario horario) {
        return service.update(id, horario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
