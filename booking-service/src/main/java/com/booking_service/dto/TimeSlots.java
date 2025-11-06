package com.booking_service.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalTime;

public class TimeSlots {

    private long id;

    private LocalTime time ;

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
