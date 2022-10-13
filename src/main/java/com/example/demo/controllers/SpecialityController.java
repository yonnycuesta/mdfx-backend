package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;
import com.example.demo.models.SpecialityModel;
import com.example.demo.services.SpecialityService;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/specialities")

public class SpecialityController {
    
    @Autowired
    private SpecialityService specialityService; // Inject SpecialityService
  
    // Get all specialities
    @GetMapping
    public ArrayList<SpecialityModel> getSpecialities() {
        return specialityService.getAllSpecialities();
    }

    // Save a speciality
    @PostMapping
    public SpecialityModel saveSpeciality(@RequestBody SpecialityModel speciality) {
        return specialityService.saveSpeciality(speciality);
    }

    // Get a speciality by id
    @GetMapping(path = "/{id}")
    public SpecialityModel getSpecialityById(@PathVariable("id") Long id) {
        return specialityService.getSpecialityById(id);
    }

    // Delete a speciality by id
    @DeleteMapping(path = "/{id}")
    public String deleteSpeciality(@PathVariable("id") Long id) {
        SpecialityModel specialty = specialityService.getSpecialityById(id);
        if (specialty == null) {
            return "Speciality not found";
        }else{
            return specialityService.deleteSpeciality(id);
        }
    }

    // Update a speciality by id
    @PutMapping(path = "/{id}")
    public SpecialityModel updateSpeciality(@RequestBody SpecialityModel speciality, @PathVariable("id") Long id) {
        SpecialityModel existingSpeciality = specialityService.getSpecialityById(id);
        if (existingSpeciality == null) {
            return null;
        }else{
            existingSpeciality.setName(speciality.getName());
            return specialityService.updateSpeciality(existingSpeciality);
        }
    }
}
