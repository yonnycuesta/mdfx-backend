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
    private SpecialityService specialityService;

    @GetMapping
    public ArrayList<SpecialityModel> getSpecialities() {
        return specialityService.getAllSpecialities();
    }
}
