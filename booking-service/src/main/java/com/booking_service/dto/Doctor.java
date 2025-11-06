package com.booking_service.dto;

import java.util.List;

public class Doctor {


    private long id;

    private String name;

    private String specialization;

    private String qualification;

    private String contact;

    private String experiance;

    private String url;

    private String address;


    private State state;

    private City city;

    private Area area;


    private List<DoctorAppointmentSchedule> appointmentSchedules;

    public List<DoctorAppointmentSchedule> getAppointmentSchedules() {
        return appointmentSchedules;
    }

    public void setAppointmentSchedules(List<DoctorAppointmentSchedule> appointmentSchedules) {
        this.appointmentSchedules = appointmentSchedules;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getExperiance() {
        return experiance;
    }

    public void setExperiance(String experiance) {
        this.experiance = experiance;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
