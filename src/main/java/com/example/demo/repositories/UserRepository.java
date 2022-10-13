package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    
    // UserModel findByEmail(String email);
}
