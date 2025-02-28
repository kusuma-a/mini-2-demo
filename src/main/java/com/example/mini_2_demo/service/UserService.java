package com.example.mini_2_demo.service;


import com.example.mini_2_demo.entity.User;
import com.example.mini_2_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Use dependency injection

    public User registerUser(User user) {
        System.out.println("User registration method called"); // Debugging

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        System.out.println("Encoded password: " + user.getPassword()); // Debugging

        user.setRole(user.getRole());
        User savedUser = userRepository.save(user);
        System.out.println("User saved: " + savedUser.getName()); // Debugging


        return savedUser;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByName(String name){
        return userRepository.findByName(name).orElse(null);
    }


}