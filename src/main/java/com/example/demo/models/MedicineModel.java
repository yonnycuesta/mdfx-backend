package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "medicines")
public class MedicineModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer qty;
    @Column(nullable = false)
    private String expirationDate;
    @Column(nullable = false)
    private String presentation;
    private String status;
    // Constructor
    public MedicineModel() {
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
    public Integer getQty() {
        return qty;
    }
    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public String getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    public String getPresentation() {
        return presentation;
    }
    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
