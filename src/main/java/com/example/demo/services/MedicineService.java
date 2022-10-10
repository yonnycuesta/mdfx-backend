package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.MedicineModel;
import com.example.demo.repositories.MedicineRepository;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository; // Inject MedicineRepository

    // Métodos

    // Encuentra un medicamento por id
    public ResponseEntity<MedicineModel> findMedicineById(Long id) {
        return medicineRepository.findById(id)
                .map(medicine -> ResponseEntity.ok().body(medicine))
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar todos los medicamentos
    public ResponseEntity<List<MedicineModel>> findAll() {
        if (medicineRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(medicineRepository.findAll());
        }
    }

    // Guardar un medicamento
    public ResponseEntity<MedicineModel> save(MedicineModel medicine) {
       if (ResponseEntity.ok().body(medicineRepository.save(medicine)) != null) {
           return ResponseEntity.ok().body(medicineRepository.save(medicine));
       } else {
           return ResponseEntity.notFound().build();
       }
    }

    // Eliminar un medicamento
    public ResponseEntity<?> delete(Long id) {
        medicineRepository.deleteById(id);
        if (medicineRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }

    // Actualizar un medicamento

    public ResponseEntity<MedicineModel> update(Long id, MedicineModel medicine) {
        // Buscar el medicamento por id
        MedicineModel medicineToUpdate = medicineRepository.findById(id).orElse(null);
        // Actualizar el medicamento
        if(medicineToUpdate != null) {
            medicineToUpdate.setName(medicine.getName());
            medicineToUpdate.setQty(medicine.getQty());
            medicineToUpdate.setExpirationDate(medicine.getExpirationDate());
            medicineToUpdate.setPresentation(medicine.getPresentation());
            medicineToUpdate.setStatus(medicine.getStatus());
            return ResponseEntity.ok().body(medicineRepository.save(medicineToUpdate));
        }else {
            return ResponseEntity.notFound().build();
        }
               
    }
}
