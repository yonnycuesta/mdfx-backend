package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.MedicineModel;
import com.example.demo.services.MedicineService;

// import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/medicines")
public class MedicineController {
    
    @Autowired
    private MedicineService medicineService; // Inject MedicineService

    // Métodos

    // Encuentra un medicamento por id
    @GetMapping(path = "/{id}")
    public ResponseEntity<MedicineModel> getById(@PathVariable("id") Long id) {
        if (medicineService.findMedicineById(id) != null) {
            return medicineService.findMedicineById(id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Buscar todos los medicamentos
    @GetMapping
    public ResponseEntity<List<MedicineModel>> findAll() {
        if (medicineService.findAll() != null) {
            return ResponseEntity.notFound().build();
        } else {
            return medicineService.findAll();
        }
    }

    // Guardar un medicamento
    @PostMapping
    public ResponseEntity<MedicineModel> save(@RequestBody MedicineModel medicine) {
        return medicineService.save(medicine);
    }

    // Eliminar un medicamento
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return medicineService.delete(id);
    }

    // Actualizar un medicamento
    @PutMapping(path = "/{id}")
    public ResponseEntity<MedicineModel> update(@PathVariable("id") Long id, @RequestBody MedicineModel medicine) {
        return medicineService.update(id, medicine);
    }
}
