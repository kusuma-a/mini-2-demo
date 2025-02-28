package com.example.mini_2_demo.repository;

import com.example.mini_2_demo.entity.Appointment;
import com.example.mini_2_demo.entity.Doctor;
import com.example.mini_2_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findByDoctorId(Long doctorId);
    List<Appointment> findByUserId(Long userId);

}




