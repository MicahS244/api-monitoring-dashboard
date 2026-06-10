package com.apimonitoring.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Class representing an incident related to an API service
@Entity
public class Incident {

    // Generates an ID for incident
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;
    private String title;
    private String severity;
    private String status;
    private String description;
    private String createdAt;

    public Incident() {
    }

    // Constructor initializing all fields
    public Incident(Long id, String serviceName, String title, String severity,
            String status, String description, String createdAt) {
        this.id = id;
        this.serviceName = serviceName;
        this.title = title;
        this.severity = severity;
        this.status = status;
        this.description = description;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getTitle() {
        return title;
    }

    public String getSeverity() {
        return severity;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}