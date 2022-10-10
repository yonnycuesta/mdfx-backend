package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.RoleRepository;
import com.example.demo.models.RoleModel;
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository; // Inject RoleRepository

    //Métodos

    // Encuentra un rol por id
    public RoleModel findRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    // Buscar todos los roles
    public ArrayList<RoleModel> findAll() {
        return (ArrayList<RoleModel>) roleRepository.findAll();
    }

    // Guardar un rol
    public RoleModel save(RoleModel role) {
        return roleRepository.save(role);
    }

    // Eliminar un rol
    public String delete(Long id) {
        roleRepository.deleteById(id);
        if (roleRepository.findById(id).isPresent()) {
            return "Role not deleted";
        } else {
            return "Role deleted";
        }
    }

}
