package com.petmanagementspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petmanagementspring.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
    
}
