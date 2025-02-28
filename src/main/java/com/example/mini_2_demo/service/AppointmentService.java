package com.example.mini_2_demo.service;


import com.example.mini_2_demo.entity.Appointment;
import com.example.mini_2_demo.entity.Doctor;
import com.example.mini_2_demo.entity.User;
import com.example.mini_2_demo.repository.AppointmentRepository;
import com.example.mini_2_demo.repository.DoctorRepository;
import com.example.mini_2_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment bookAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsForDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public List<Appointment> getAppointmentsForPatient(Long userId) {
        return appointmentRepository.findByUserId(userId);
    }
}










