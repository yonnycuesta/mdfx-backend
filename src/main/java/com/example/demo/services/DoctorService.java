package com.example.demo.services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.DoctorRepository;
import com.example.demo.models.DoctorModel;
@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository; // Inject DoctorRepository

    //Métodos
    // Encuentra un doctor por id
    public DoctorModel findDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }
    // Buscar todos los doctores
    public ArrayList<DoctorModel> findAll() {
        return (ArrayList<DoctorModel>) doctorRepository.findAll();
    }
    // Guardar un doctor
    public DoctorModel save(DoctorModel doctor) {
        return doctorRepository.save(doctor);
    }
    // Eliminar un doctor
    public String delete(Long id) {
        doctorRepository.deleteById(id);
        if (doctorRepository.findById(id).isPresent()) {
            return "Doctor not deleted";
        } else {
            return "Doctor deleted";
        }
    }
}
