package com.example.demo.models;
import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "schedules")
public class ScheduleModel implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(unique = true, nullable = false) 
    private Long id;
    @Column(nullable = false)
    private String hour;
    @Column(nullable = false)
    private String status;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id", nullable = false, referencedColumnName = "id")
    private DoctorModel doctor;

    /**
     * 
     */
    public ScheduleModel() {
        
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

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DoctorModel getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorModel doctor) {
        this.doctor = doctor;
    }
    
}
