package com.cpe.backend.Payment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
//import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.Payment.repository.MedicineRepository;
import com.cpe.backend.Payment.entity.Medicine;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController

public class MedicineController {

  
    @Autowired
    private final MedicineRepository  medicineRepository;

    public MedicineController(MedicineRepository medicineRepository) {
            this.medicineRepository = medicineRepository;
    }
    @GetMapping("/medicine")
    public Collection<Medicine> getMedicineAll() {
        return medicineRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/medicine/{id}/{name}/{price}")
    public Medicine getMedicineById(@PathVariable("id") Long id) {
         return medicineRepository.findById(id).get();
    }
}
   
