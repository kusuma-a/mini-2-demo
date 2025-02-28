package com.example.mini_2_demo.security;

import com.example.mini_2_demo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

    @Bean
    public UserService userDetailsService(UserService userService) {
        return userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/register","/login", "/css/*", "/js/*").permitAll() // Allow register page & static resources
                        .requestMatchers("/doctors/**").hasAuthority("ROLE_DOCTOR") // Only doctors can access
                        .requestMatchers("/appointments/**").hasAnyRole("USER","DOCTOR") // Only users (patients) can access
                        .anyRequest().authenticated() // Everything else requires authentication
                )
                .formLogin(login -> login
                        .loginPage("/users/login")
                        .loginProcessingUrl("/users/login") // URL to process login form
                        .successHandler(loginSuccessHandler()) // Custom success handler
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/users/logout")
                        .logoutSuccessUrl("/users/login?logout")
                        .permitAll()
                )
                .exceptionHandling(exception->exception.accessDeniedPage("/403"));

        return http.build();
    }

    
}
