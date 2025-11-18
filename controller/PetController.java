package com.healthypetsbackend.HealthyPetsBackend.controller;

import com.healthypetsbackend.HealthyPetsBackend.model.Pet;
import com.healthypetsbackend.HealthyPetsBackend.model.User;
import com.healthypetsbackend.HealthyPetsBackend.service.PetService;
import com.healthypetsbackend.HealthyPetsBackend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin("*")
public class PetController {

    private final PetService petService;
    private final UserService userService;

    public PetController(PetService petService, UserService userService) {
        this.petService = petService;
        this.userService = userService;
    }

    @PostMapping("/create/{userId}")
    public Pet createPet(@PathVariable Long userId, @RequestBody Pet pet) {
        User owner = userService.getById(userId);
        pet.setOwner(owner);
        return petService.save(pet);
    }

    @GetMapping("/owner/{userId}")
    public List<Pet> getPetsByOwner(@PathVariable Long userId) {
        User owner = userService.getById(userId);
        return petService.getPetsByOwner(owner);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.delete(id);
    }
}
