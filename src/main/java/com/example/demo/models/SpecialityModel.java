package com.example.demo.models;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "specialities")

public class SpecialityModel implements Serializable{
    private static final long serialVersionUID = 1L;
    // Attributes
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    @Column(unique = true, nullable = false) // Unique and Not Null
    private Long id;
    @Column(unique = true, nullable = false) // Unique and Not Null
    private String name;

    @ManyToMany(mappedBy = "specialities", fetch = FetchType.LAZY)
    private List<DoctorModel> doctors;


     // Constructor
     public SpecialityModel() {
    }

    public List<DoctorModel> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<DoctorModel> doctors) {
        this.doctors = doctors;
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
