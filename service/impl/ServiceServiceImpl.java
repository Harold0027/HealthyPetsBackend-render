package com.healthypetsbackend.HealthyPetsBackend.service.impl;

import com.healthypetsbackend.HealthyPetsBackend.model.ServiceEntity;
import com.healthypetsbackend.HealthyPetsBackend.repository.ServiceRepository;
import com.healthypetsbackend.HealthyPetsBackend.service.ServiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository repository;

    public ServiceServiceImpl(ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceEntity save(ServiceEntity service) {
        return repository.save(service);
    }

    @Override
    public List<ServiceEntity> listAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ServiceEntity getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
