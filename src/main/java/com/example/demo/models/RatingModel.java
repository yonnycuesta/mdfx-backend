package com.example.demo.models;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class RatingModel implements Serializable{
    @Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false) 
	private Long id;
    @Column(nullable = false)
    private Integer note;
    @Column(nullable = true)
    private String comment;

    // Relationships

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_id", referencedColumnName = "id")
    private AppointmentModel appointment;

    // Constructor
    public RatingModel() {
    }

    // Getters and Setters Methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public AppointmentModel getAppointment() {
        return appointment;
    }

    public void setAppointment(AppointmentModel appointment) {
        this.appointment = appointment;
    }
}
