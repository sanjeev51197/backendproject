package com.doctor_service.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "doctor_appointment_schedule")
public class DoctorAppointmentSchedule {

             @Id
             @GeneratedValue(strategy = GenerationType.IDENTITY)
             @Column(name = "id",nullable = false)
             private long id;

             @Column(name = "date")
             private LocalDate date;

             @ManyToOne(cascade = CascadeType.ALL)
             @JoinColumn(name="doctor_id")
             @JsonBackReference   //child side of doctor
             private Doctor doctor;

    @OneToMany(mappedBy = "doctorAppointmentSchedule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<TimeSlots> timeSlots;

    public List<TimeSlots> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlots> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
