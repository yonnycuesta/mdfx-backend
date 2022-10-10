package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.RoleModel;
import com.example.demo.services.RoleService;
import java.util.*;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService; // Inject RoleService

    // Métodos
    // Buscar un rol por nombre
    // @GetMapping(path = "/{name}")
    // public RoleModel getByName(@PathVariable("name") String name) {
    //     return roleService.findRoleByName(name);
    // }

    // Encuentra un rol por id
    @GetMapping(path = "/{id}")
    public RoleModel getById(@PathVariable("id") Long id) {
        return roleService.findRoleById(id);
    }

    // Buscar todos los roles
    @GetMapping
    public ArrayList<RoleModel> findAll() {
        if (roleService.findAll().isEmpty()) {
            return null;
        } else {
            return roleService.findAll();
        }
    }

    // Guardar un rol
    @PostMapping
    public RoleModel save(@RequestBody RoleModel role) {
        return roleService.save(role);
    }

    // Eliminar un rol
    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable("id") Long id) {
        return roleService.delete(id);
    }

    // Actualizar un rol
    @PutMapping(path = "/{id}")
    public RoleModel update(@PathVariable("id") Long id, @RequestBody RoleModel role) {
        RoleModel existingRole = roleService.findRoleById(id);
        if (existingRole != null) {
            existingRole.setName(role.getName());
            return roleService.save(existingRole);
        } else {
            return null;
        }
    }
}
