package com.example.mini_2_demo.controller;

import com.example.mini_2_demo.entity.User;
import com.example.mini_2_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        System.out.println("Register controller method called");
        userService.registerUser(user);
        System.out.println("User registered id redirected to login...");
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String ShowLoginForm(){
        return "login";
    }
}