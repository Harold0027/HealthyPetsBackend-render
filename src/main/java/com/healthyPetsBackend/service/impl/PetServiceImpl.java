package com.healthyPetsBackend.service.impl;

import com.healthyPetsBackend.model.Pet;
import com.healthyPetsBackend.model.User;
import com.healthyPetsBackend.repository.PetRepository;
import com.healthyPetsBackend.service.PetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository repository;

    public PetServiceImpl(PetRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pet save(Pet pet) {
        return repository.save(pet);
    }

    @Override
    public List<Pet> getPetsByOwner(User owner) {
        return repository.findByOwner(owner);
    }

    @Override
    public Pet getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
