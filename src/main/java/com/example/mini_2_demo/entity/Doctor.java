package com.example.mini_2_demo.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialty;
    private String email;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> doctorAppointments;

    public Doctor() {
    }

    public Doctor(List<Appointment> doctorAppointments, String email, Long id, String name, String specialty) {
        this.doctorAppointments = doctorAppointments;
        this.email = email;
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public List<Appointment> getDoctorAppointments() {
        return doctorAppointments;
    }

    public void setDoctorAppointments(List<Appointment> doctorAppointments) {
        this.doctorAppointments = doctorAppointments;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}