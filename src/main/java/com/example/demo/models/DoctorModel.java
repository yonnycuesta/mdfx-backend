package com.example.demo.models;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "doctors")
public class DoctorModel implements Serializable {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
	@Column(unique = true, nullable = false) // Unique and Not Null
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String lastName;
	@Column(unique = true)
	private String phone;
	@Column(unique = true, nullable = false)
	private String email;

	// Relationships
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "doctors_specialities", joinColumns = {
			@JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "speciality_id", referencedColumnName = "id", nullable = false, updatable = false) })

	private List<SpecialityModel> specialities;

	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ScheduleModel> schedules;

	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AppointmentModel> appointments;

	// Constructor
	public DoctorModel() {

	}

	// Getters and Setters Methods
	public List<AppointmentModel> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<AppointmentModel> appointments) {
		this.appointments = appointments;
	}

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<SpecialityModel> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(List<SpecialityModel> specialities) {
		this.specialities = specialities;
	}

	public List<ScheduleModel> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<ScheduleModel> schedules) {
		this.schedules = schedules;
	}

}
