package com.apimonitoring.backend.controller;

import com.apimonitoring.backend.model.ApiService;
import com.apimonitoring.backend.model.Incident;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MonitoringController {

    private final List<ApiService> services = new ArrayList<>();
    private final List<Incident> incidents = new ArrayList<>();
    private Long incidentIdCounter = 3L;

    public MonitoringController() {
        services.add(new ApiService(1L, "Entitlements API", "Wealth Platform", "PROD", "Healthy", 120, 0.2, "2026-05-28 10:30 AM"));
        services.add(new ApiService(2L, "Payments API", "Transfer Services", "DEV", "Degraded", 450, 3.1, "2026-05-28 10:28 AM"));
        services.add(new ApiService(3L, "User Profile API", "Customer Data", "UAT", "Down", 900, 8.5, "2026-05-28 10:25 AM"));
        services.add(new ApiService(4L, "Notification API", "Messaging", "PROD", "Healthy", 180, 0.5, "2026-05-28 10:31 AM"));

        incidents.add(new Incident(1L, "Payments API", "Elevated response times", "High", "Open",
                "Payments API is experiencing slower than normal response times.", "2026-05-28 09:45 AM"));

        incidents.add(new Incident(2L, "User Profile API", "Service unavailable in UAT", "Critical", "Open",
                "User Profile API is returning errors during UAT validation.", "2026-05-28 09:15 AM"));
    }

    @GetMapping("/services")
    public List<ApiService> getServices() {
        return services;
    }

    @GetMapping("/incidents")
    public List<Incident> getIncidents() {
        return incidents;
    }

    @PostMapping("/incidents")
    public Incident createIncident(@RequestBody Incident incident) {
        incident.setId(incidentIdCounter++);
        incident.setStatus("Open");
        incident.setCreatedAt(LocalDateTime.now().toString());
        incidents.add(incident);
        return incident;
    }

    @PutMapping("/incidents/{id}/resolve")
    public Incident resolveIncident(@PathVariable Long id) {
        for (int i = 0; i < incidents.size(); i++) {
            Incident incident = incidents.get(i);
            if (incident.getId().equals(id)) {
                incident.setStatus("Resolved");
                return incident;
            }
        }
        throw new RuntimeException("Incident not found");
    }
}