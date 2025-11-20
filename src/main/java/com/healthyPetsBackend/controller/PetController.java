package com.healthyPetsBackend.controller;

import com.healthyPetsBackend.model.Pet;
import com.healthyPetsBackend.model.User;
import com.healthyPetsBackend.service.PetService;
import com.healthyPetsBackend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin(origins = "*")
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
