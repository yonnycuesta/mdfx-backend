package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "roles")
public class RoleModel implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<UserModel> users;

    // Constructor
    public RoleModel() {
    }

    // Getters and Setters Methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
