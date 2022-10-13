package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.RoleModel;
import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // Get All Users
    public ResponseEntity<List<UserModel>> getAllUsers() {
        if (userRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userRepository.findAll());
        }
    }

    // Get User by id
    public ResponseEntity<UserModel> getUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            return ResponseEntity.ok(userRepository.findById(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Save a user
    public ResponseEntity<UserModel> saveUser(UserModel user) {
            // role = 1 -> user
            RoleModel role = new RoleModel();
            role.setId(2L);
            user.setRole(role);
            return ResponseEntity.ok(userRepository.save(user));
        
    }

    // Delete a user by id
    public ResponseEntity<String> deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a user by id
    public ResponseEntity<UserModel> updateUser(UserModel user, Long id) {
        if (userRepository.findById(id).isPresent()) {
            UserModel existingUser = userRepository.findById(id).get();
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setRole(user.getRole());
            return ResponseEntity.ok(userRepository.save(existingUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Login
    // public ResponseEntity<UserModel> login(String email, String password) {
    //     if (userRepository.findByEmailAndPassword(email, password).isPresent()) {
    //         return ResponseEntity.ok(userRepository.findByEmailAndPassword(email, password).get());
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

}
