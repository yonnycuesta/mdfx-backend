package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "users")

public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(unique = true, nullable = false) 
    private Long id;
    @Column(unique = true, nullable = false) 
    private String username;
    private String email;
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false, referencedColumnName = "id")
    private RoleModel role;
    
    // Constructor
    public UserModel() {
    }

    // Getters and Setters Methods
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
   
    public void setPassword(String password) {
        this.password = password;
    }
    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }
}
