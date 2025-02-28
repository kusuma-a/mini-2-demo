package com.example.mini_2_demo.service;


import com.example.mini_2_demo.entity.Doctor;
import com.example.mini_2_demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getDoctorsBySpecialty(String specialty) {
        return doctorRepository.findBySpecialty(specialty);
    }

    public Doctor findById(Long doctorId) {
        return doctorRepository.findById(doctorId).orElse(null);
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

}