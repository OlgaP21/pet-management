package com.petmanagementspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petmanagementspring.model.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {
    
}
