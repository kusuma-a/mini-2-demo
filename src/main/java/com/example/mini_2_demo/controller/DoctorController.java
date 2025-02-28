package com.example.mini_2_demo.controller;


import com.example.mini_2_demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

   // @GetMapping("/list")
    //public String listDoctors(@RequestParam String specialty, Model model) {
      //  model.addAttribute("doctors", doctorService.getDoctorsBySpecialty(specialty));
        //return "doctor-list";
    //}

    @GetMapping("/list")
    public String listDoctors(@RequestParam(required = false) String specialty, Model model) {
        if (specialty != null && !specialty.isEmpty()) {
            model.addAttribute("doctors", doctorService.getDoctorsBySpecialty(specialty));
        } else {
            model.addAttribute("doctors", doctorService.getAllDoctors()); // Show all doctors if no specialty is provided
        }
        return "doctor-list";
    }
}