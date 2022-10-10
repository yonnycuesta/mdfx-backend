package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    // Find a role by name
    public RoleModel findByName(String name);   
}
