package com.petmanagementspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petmanagementspring.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
    
}
