package com.healthypetsbackend.HealthyPetsBackend.controller;

import com.healthypetsbackend.HealthyPetsBackend.model.ServiceEntity;
import com.healthypetsbackend.HealthyPetsBackend.service.ServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin("*")
public class ServiceController {

    private final ServiceService service;

    public ServiceController(ServiceService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ServiceEntity create(@RequestBody ServiceEntity serviceEntity) {
        return service.save(serviceEntity);
    }

    @GetMapping
    public List<ServiceEntity> list() {
        return service.listAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
