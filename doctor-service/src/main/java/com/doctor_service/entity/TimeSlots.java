package com.doctor_service.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "time_slots")
public class TimeSlots {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private long id;
    @Column(name = "time")
    private LocalTime time ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_schedule_id")
    @JsonBackReference
    private DoctorAppointmentSchedule doctorAppointmentSchedule;

    public DoctorAppointmentSchedule getDoctorAppointmentSchedule() {
        return doctorAppointmentSchedule;
    }

    public void setDoctorAppointmentSchedule(DoctorAppointmentSchedule doctorAppointmentSchedule) {
        this.doctorAppointmentSchedule = doctorAppointmentSchedule;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
