package com.healthypetsbackend.HealthyPetsBackend.repository;

import com.healthypetsbackend.HealthyPetsBackend.model.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
}
