package com.apimonitoring.backend.controller;

import com.apimonitoring.backend.model.LoginRequest;
import com.apimonitoring.backend.model.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.apimonitoring.backend.service.JwtService;

@CrossOrigin(origins = { "http://localhost:4200", "http://127.0.0.1:4200" })
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        if ("admin".equals(loginRequest.getUsername()) && "password".equals(loginRequest.getPassword())) {

            String token = jwtService.generateToken(loginRequest.getUsername()); // Generate a new token

            LoginResponse response = new LoginResponse("Login Succesful", true, token);
            
            return ResponseEntity.ok(response);
        } else {
            LoginResponse response = new LoginResponse("Invalid credentials", false, null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

}