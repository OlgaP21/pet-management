package com.petmanagementspring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petmanagementspring.model.Pet;
import com.petmanagementspring.repository.PetRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PetController {
    
    @Autowired
    PetRepository petRepository;

    @GetMapping("/pets")
    public ResponseEntity<List<Pet>> getAllPets() {
        try {
            List<Pet> pets = new ArrayList<>();
            petRepository.findAll().forEach(pets::add);
            if (pets.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(pets, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable("id") long id) {
        Optional<Pet> petData = petRepository.findById(id);
        if (petData.isPresent()) {
            return new ResponseEntity<>(petData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/pets")
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        try {
            Pet _pet = petRepository.save(new Pet(pet.getName(), pet.getCode(), pet.getType(), pet.getColor(), pet.getCountry()));
            return new ResponseEntity<Pet>(_pet, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pets/{id}")
    public ResponseEntity<Pet> editPet(@PathVariable("id")long id, @RequestBody Pet pet) {
        Optional<Pet> petData = petRepository.findById(id);
        if (petData.isPresent()) {
            Pet _pet = petData.get();
            _pet.setName(pet.getName());
            _pet.setCode(pet.getCode());
            _pet.setType(pet.getType());
            _pet.setColor(pet.getColor());
            _pet.setCountry(pet.getCountry());
            return new ResponseEntity<>(petRepository.save(_pet), HttpStatus.OK);
        } else {
            return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
        }
    }
}
