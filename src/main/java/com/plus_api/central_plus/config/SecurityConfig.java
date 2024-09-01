package com.plus_api.central_plus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for simplicity; consider enabling it for production
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/**", "/product", "/activities/**", "/categories/**", "/categoriesproduct/**", "/commands/**", "/customers/**", "/marchand-buyers/**", "/merchants/**", "/stocks/**", "/suppliers/**", "/payments/**").permitAll()  // Allow public access to specified endpoints
                        .anyRequest().authenticated()  // Secure all other endpoints
                );

        return http.build();
    }
}
