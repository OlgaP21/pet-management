package com.petmanagementspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petmanagementspring.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
    
}