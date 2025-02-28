package com.example.mini_2_demo.security;

import com.example.mini_2_demo.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.logging.Logger;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    private static final Logger logger = Logger.getLogger(LoginSuccessHandler.class.getName());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("Login successful for user: " + authentication.getName());

        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_DOCTOR"))) {
            logger.info("Redirecting to /doctors/list");
            response.sendRedirect("/doctors/list");
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))) {
            logger.info("Redirecting to /appointments/book");
            response.sendRedirect("/appointments/book");
        } else {
            logger.warning("No valid role found, redirecting to /403");
            response.sendRedirect("/403");
        }
    }
}





























