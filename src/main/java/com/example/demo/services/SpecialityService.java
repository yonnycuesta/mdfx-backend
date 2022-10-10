package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.SpecialityModel;
import com.example.demo.repositories.SpecialityRepository;
import java.util.*;

@Service
public class SpecialityService {
    @Autowired
    private SpecialityRepository specialityRepository;
    // Get All Specialities
    public ArrayList<SpecialityModel> getAllSpecialities() {
        return (ArrayList<SpecialityModel>) specialityRepository.findAll();
    }
    // Get Speciality By Id
    public SpecialityModel getSpecialityById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }
    // Create Speciality
    public SpecialityModel saveSpeciality(SpecialityModel speciality) {
        return specialityRepository.save(speciality);
    }
    // Delete Speciality
    public String deleteSpeciality(Long id) {
        specialityRepository.deleteById(id);
        return "Speciality removed !! ";
    }
    // Update Speciality
    public SpecialityModel updateSpeciality(SpecialityModel speciality) {
        SpecialityModel existingSpeciality = specialityRepository.findById(speciality.getId()).orElse(null);
        existingSpeciality.setName(speciality.getName());
        return specialityRepository.save(existingSpeciality);
    }
}
