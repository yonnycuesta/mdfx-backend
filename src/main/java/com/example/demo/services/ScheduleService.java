package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.ScheduleModel;
import com.example.demo.repositories.ScheduleRepository;

@Service
public class ScheduleService {
    
    @Autowired
    private ScheduleRepository scheduleRepository; // Inject ScheduleRepository

    // Métodos

    // Encuentra un horario por id
    public ResponseEntity<ScheduleModel> findScheduleById(Long id) {
        return scheduleRepository.findById(id)
                .map(schedule -> ResponseEntity.ok().body(schedule))
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar todos los horarios
    public ResponseEntity<List<ScheduleModel>> findAll() {
        if (scheduleRepository.findAll() != null) {
            return ResponseEntity.ok().body(scheduleRepository.findAll());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Guardar un horario
    public ResponseEntity<ScheduleModel> save(ScheduleModel schedule) {
        if (ResponseEntity.ok().body(scheduleRepository.save(schedule)) != null) {
            return ResponseEntity.ok().body(scheduleRepository.save(schedule));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un horario
    public ResponseEntity<?> delete(Long id) {
        scheduleRepository.deleteById(id);
        if (scheduleRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }

    // Actualizar un horario

    public ResponseEntity<ScheduleModel> update(Long id, ScheduleModel schedule) {
        // Buscar el horario por id
        ScheduleModel scheduleToUpdate = scheduleRepository.findById(id).orElse(null);
        // Actualizar el horario
        scheduleToUpdate.setStatus(schedule.getStatus());
        scheduleToUpdate.setHour(schedule.getHour());
        scheduleToUpdate.setDoctor(schedule.getDoctor());
        // Guardar el horario actualizado
        return ResponseEntity.ok().body(scheduleRepository.save(scheduleToUpdate));
    }
}
