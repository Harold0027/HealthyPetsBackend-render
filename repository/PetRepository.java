package com.healthypetsbackend.HealthyPetsBackend.repository;

import com.healthypetsbackend.HealthyPetsBackend.model.Pet;
import com.healthypetsbackend.HealthyPetsBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByOwner(User owner);
}
