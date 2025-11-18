package com.healthypetsbackend.HealthyPetsBackend.service;

import com.healthypetsbackend.HealthyPetsBackend.model.Pet;
import com.healthypetsbackend.HealthyPetsBackend.model.User;

import java.util.List;

public interface PetService {

    Pet save(Pet pet);

    List<Pet> getPetsByOwner(User owner);

    Pet getById(Long id);

    void delete(Long id);
}
