package com.doctor_service.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "specialization",nullable = false)
    private String specialization;
    @Column(name = "qualification",nullable = false)
    private String qualification;
    @Column(name = "contact",nullable = false)
    private String contact;
    @Column(name = "experiance",nullable = false)
    private String experiance;
    @Column(name = "url",nullable = false,length = 2000)
    private String url;
    @Column(name = "address",nullable = false,length = 1000)
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id")
    private State state;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="city_id")
    private City city;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="area_id")
    private Area area;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference  //parent side
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
