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

    public ArrayList<SpecialityModel> getAllSpecialities() {
        return (ArrayList<SpecialityModel>) specialityRepository.findAll();
    }

    public SpecialityModel getSpecialityById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    public SpecialityModel saveSpeciality(SpecialityModel speciality) {
        return specialityRepository.save(speciality);
    }

    public String deleteSpeciality(Long id) {
        specialityRepository.deleteById(id);
        return "Speciality removed !! " + id;
    }

    public SpecialityModel updateSpeciality(SpecialityModel speciality) {
        SpecialityModel existingSpeciality = specialityRepository.findById(speciality.getId()).orElse(null);
        existingSpeciality.setName(speciality.getName());
        return specialityRepository.save(existingSpeciality);
    }
}
