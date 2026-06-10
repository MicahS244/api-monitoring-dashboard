package com.apimonitoring.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig {

    //Defines how to handle incoming HTTP requests 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll() //Allow all requests with auth
                .requestMatchers("/api/public/**").permitAll()
                .anyRequest().authenticated() //All other requests require authenticaiton 
            )

            .formLogin(form -> form.disable()) //Disables Spring's default form login 
            .httpBasic(basic -> basic.disable());

            return http.build();
    }
    
}
