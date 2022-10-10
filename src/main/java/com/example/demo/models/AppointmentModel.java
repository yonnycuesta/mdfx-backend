package com.example.demo.models;

import java.io.Serializable;
// import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "appointments")

public class AppointmentModel implements Serializable{
    
    @Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
    @Column(nullable = false)
    private String programation_date;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String comment;
    @Column(nullable = false)
    private String reason;
    @Column(nullable = false)
    // Patient
    private String patient_name;
    @Column(nullable = false)
    private String patient_lastname;
    @Column(nullable = false)
    private String patient_email;
    @Column(nullable = false)
    private String patient_phone;
    @Column(nullable = false)
    private String patient_dni;
    @Column(nullable = false)
    private String patient_address;
    @Column(nullable = false)
    private String patient_age;
    // Doctor
    @Column(nullable = false)
    private String doctor_name;
    // Schedule
    @Column(nullable = false)
    private String schedule_hour;

    // Relationship
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id", nullable = false, referencedColumnName = "id")
    private DoctorModel doctor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false, referencedColumnName = "id")
    private PatientModel patient;

    @OneToOne(mappedBy = "appointment")
    private RatingModel rating;
    // Constructor
    public AppointmentModel() {
    }

    // Getters and Setters Methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProgramation_date() {
        return programation_date;
    }

    public void setProgramation_date(String programation_date) {
        this.programation_date = programation_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_lastname() {
        return patient_lastname;
    }

    public void setPatient_lastname(String patient_lastname) {
        this.patient_lastname = patient_lastname;
    }

    public String getPatient_email() {
        return patient_email;
    }

    public void setPatient_email(String patient_email) {
        this.patient_email = patient_email;
    }

    public String getPatient_phone() {
        return patient_phone;
    }

    public void setPatient_phone(String patient_phone) {
        this.patient_phone = patient_phone;
    }

    public String getPatient_dni() {
        return patient_dni;
    }

    public void setPatient_dni(String patient_dni) {
        this.patient_dni = patient_dni;
    }

    public String getPatient_address() {
        return patient_address;
    }

    public void setPatient_address(String patient_address) {
        this.patient_address = patient_address;
    }

    public String getPatient_age() {
        return patient_age;
    }

    public void setPatient_age(String patient_age) {
        this.patient_age = patient_age;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getSchedule_hour() {
        return schedule_hour;
    }

    public void setSchedule_hour(String schedule_hour) {
        this.schedule_hour = schedule_hour;
    }

    public DoctorModel getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorModel doctor) {
        this.doctor = doctor;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }
}
