package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.ScheduleModel;
import com.example.demo.services.ScheduleService;
import java.util.*;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService; // Inject ScheduleService

    // Métodos

    // Encuentra un horario por id
    @GetMapping(path = "/{id}")
    public ResponseEntity<ScheduleModel> getById(@PathVariable("id") Long id) {
        return scheduleService.findScheduleById(id);
    }

    // Buscar todos los horarios
    @GetMapping
    public ResponseEntity<List<ScheduleModel>> findAll() {
        if (scheduleService.findAll() == null) {
            return null;
        } else {
            return scheduleService.findAll();
        }
    }

    // Guardar un horario
    @PostMapping
    public ResponseEntity<ScheduleModel> save(@RequestBody ScheduleModel schedule) {
        return scheduleService.save(schedule);
    }

    // Eliminar un horario
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return scheduleService.delete(id);
    }

    // Actualizar un horario
    @PutMapping(path = "/{id}")
    public ResponseEntity<ScheduleModel> update(@PathVariable("id") Long id, @RequestBody ScheduleModel schedule) {
        return scheduleService.update(id, schedule);
    }
}
