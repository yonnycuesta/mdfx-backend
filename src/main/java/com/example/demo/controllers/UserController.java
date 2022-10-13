package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    // Métodos
    // Get all users

    @GetMapping
    public ResponseEntity<List<UserModel>> getUsers() {
        return userService.getAllUsers();
    }

    // Save a user
    @PostMapping
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserModel user) {
        return userService.saveUser(user);
    }

    // Get a user by id
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    // Delete a user by id
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        return userService.deleteUser(id);
    }

    // Update a user by id
    /**
     * @param user
     * @param id
     * @return
     */
    @PutMapping(path = "/{id}")
    public ResponseEntity<UserModel> updateUser(@RequestBody UserModel user, @PathVariable("id") Long id) {
        return userService.updateUser(user, id);
    }

    // // Login
    // /**
    //  * @param email
    //  * @param password
    //  * @return
    //  */
    // @PostMapping(path = "/login")
    // public ResponseEntity<UserModel> login(@RequestBody String email, @RequestBody String password) {
    //     return userService.login(email, password);
    // }
}
