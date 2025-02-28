package com.example.mini_2_demo.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    @Column(nullable = false)
    private String role; // "PATIENT" or "DOCTOR"



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

   // @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    //private List<Appointment> doctorAppointments;

    public User() {
    }

    public User( String email, Long id, String name, String password, List<Appointment> appointments, String role) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
        this.appointments =appointments;
        this.role = role;
    }

    //public List<Appointment> getDoctorAppointments() {
      //  return doctorAppointments;
    //}

    //public void setDoctorAppointments(List<Appointment> doctorAppointments) {
      //  this.doctorAppointments = doctorAppointments;
    //}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}