package com.healthypetsbackend.HealthyPetsBackend.controller;

import com.healthypetsbackend.HealthyPetsBackend.model.Appointment;
import com.healthypetsbackend.HealthyPetsBackend.model.Pet;
import com.healthypetsbackend.HealthyPetsBackend.service.AppointmentService;
import com.healthypetsbackend.HealthyPetsBackend.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin("*")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final PetService petService;

    public AppointmentController(AppointmentService appointmentService, PetService petService) {
        this.appointmentService = appointmentService;
        this.petService = petService;
    }

    @PostMapping("/create/{petId}")
    public Appointment createAppointment(@PathVariable Long petId, @RequestBody Appointment appointment) {
        Pet pet = petService.getById(petId);
        appointment.setPet(pet);
        return appointmentService.save(appointment);
    }

    @GetMapping("/pet/{petId}")
    public List<Appointment> getAppointments(@PathVariable Long petId) {
        Pet pet = petService.getById(petId);
        return appointmentService.getByPet(pet);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.delete(id);
    }
}
