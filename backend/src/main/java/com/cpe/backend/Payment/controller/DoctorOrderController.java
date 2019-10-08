package com.cpe.backend.Payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.cpe.backend.Payment.repository.DoctorOrderRepository;
import com.cpe.backend.Payment.entity.DoctorOrder;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
public class DoctorOrderController {

    @Autowired
    private final DoctorOrderRepository doctorOrderRepository;

    public DoctorOrderController(DoctorOrderRepository doctorOrderRepository) {
        this.doctorOrderRepository = doctorOrderRepository;
    }

    @GetMapping("/doctororder")
    public Collection<DoctorOrder> doctororder() {
        return doctorOrderRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/doctororder/{id}")
    public Optional<DoctorOrder> doctororders(@PathVariable Long id) {
        Optional<DoctorOrder> doctororders = doctorOrderRepository.findById(id);
        return doctororders;
    }

  
   
}