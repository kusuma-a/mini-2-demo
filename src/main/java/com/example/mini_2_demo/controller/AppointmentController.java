package com.example.mini_2_demo.controller;

import com.example.mini_2_demo.entity.Appointment;
import com.example.mini_2_demo.entity.Doctor;
import com.example.mini_2_demo.entity.User;
import com.example.mini_2_demo.service.AppointmentService;
import com.example.mini_2_demo.service.DoctorService;
import com.example.mini_2_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;


    @GetMapping("/book")
    public String showBookingForm(@RequestParam Long doctorId, Model model) {
        model.addAttribute("doctorId",doctorId);
        model.addAttribute("appointment", new Appointment());
        return "book-appointment";
    }

    @PostMapping("/book")
    public String bookAppointment(@ModelAttribute Appointment appointment, @RequestParam Long doctorId, Principal principal) {
        User user = userService.findByName(principal.getName()); // Get logged-in user
        Doctor doctor = doctorService.findById(doctorId); // Fetch doctor

        appointment.setUser(user);
        appointment.setDoctor(doctor);

        appointmentService.bookAppointment(appointment);
        return "redirect:/appointments/list";
    }

    @GetMapping("/list")
    public String showAppointments(Model model,Principal principal) {
       // System.out.println("Logged-in user:"+(principal != null? principal.getName():"no user logged in"));
        //model.addAttribute("appointments", appointmentService.getAppointmentsForPatient(1L)); // Example Patient ID
        User user = userService.findByName(principal.getName()); // Get logged-in user
        model.addAttribute("appointments", appointmentService.getAppointmentsForPatient(user.getId()));


        return "appointment-list";
    }
}