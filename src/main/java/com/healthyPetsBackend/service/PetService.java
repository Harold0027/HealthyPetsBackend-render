package com.healthyPetsBackend.service;

import com.healthyPetsBackend.model.Pet;
import com.healthyPetsBackend.model.User;

import java.util.List;

public interface PetService {

    Pet save(Pet pet);

    List<Pet> getPetsByOwner(User owner);

    Pet getById(Long id);

    void delete(Long id);
}
