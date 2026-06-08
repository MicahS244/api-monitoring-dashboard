package com.apimonitoring.backend.controller;

import com.apimonitoring.backend.model.ApiService;
import com.apimonitoring.backend.model.Incident;
import com.apimonitoring.backend.service.MonitoringService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;


@CrossOrigin(origins = {"http://localhost:4200", "http://127.0.0.1:4200/"})
@RestController
@RequestMapping("/api")
public class MonitoringController {

    private final MonitoringService monitoringService;

    public MonitoringController(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @GetMapping("/services")
    public List<ApiService> getServices() {
        return monitoringService.getServices();
    }

    @GetMapping("/incidents")
    public List<Incident> getIncidents() {
        return monitoringService.getIncidents();
    }

    @PostMapping("/incidents")
    public ResponseEntity<?> createIncident(@RequestBody Incident incident) {
        if(incident.getServiceName() == null || incident.getDescription() == null || incident.getSeverity() == null) {
            return ResponseEntity.badRequest().body("Missing required fields: serviceName, description, severity");
        }
        Incident createdIncident = monitoringService.createIncident(incident);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIncident);
    }

    @PutMapping("/incidents/{id}/resolve")
    public ResponseEntity<Incident> resolveIncident(@PathVariable Long id) {
        return monitoringService.resolveIncident(id)
                .map(resolvedIncident -> ResponseEntity.ok(resolvedIncident))
                .orElse(ResponseEntity.notFound().build());
            }
        }