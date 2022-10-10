package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.DoctorModel;
import com.example.demo.services.DoctorService;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService; // Inject DoctorService

    // Métodos

    // Encuentra un doctor por id
    @GetMapping(path = "/{id}")
    public ResponseEntity<DoctorModel> getById(@PathVariable("id") Long id) {
        DoctorModel doctor = doctorService.findDoctorById(id);
        if (doctor != null) {
            return ResponseEntity.ok(doctor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Buscar todos los doctores
    @GetMapping
    public ResponseEntity<ArrayList<DoctorModel>> findAll() {
        ArrayList<DoctorModel> doctors = doctorService.findAll();
        if (doctors.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(doctors);
        }
    }

    // Guardar un doctor
    @PostMapping
    public ResponseEntity<DoctorModel> save(@RequestBody DoctorModel doctor) {
        return ResponseEntity.ok(doctorService.save(doctor));
    }

    // Eliminar un doctor
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        String response = doctorService.delete(id);
        if (response.equals("Doctor deleted")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar un doctor

    @PutMapping(path = "/{id}") 
    public ResponseEntity<DoctorModel> update(@PathVariable("id") Long id, @RequestBody DoctorModel doctor) {
        DoctorModel existingDoctor = doctorService.findDoctorById(id);
        if (existingDoctor != null) {
            // Setear los nuevos valores
            existingDoctor.setEmail(doctor.getEmail());
            existingDoctor.setName(doctor.getName());
            existingDoctor.setLastName(doctor.getLastName());
            existingDoctor.setPhone(doctor.getPhone());
            return ResponseEntity.ok(doctorService.save(existingDoctor));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

}
