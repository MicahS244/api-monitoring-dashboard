package com.apimonitoring.backend.model;

public class ApiService {
    // Class implementation
    private Long id;
    private String name;
    private String ownerTeam;
    private String environment;
    private String status;
    private int averageResponseTimeMs;
    private double errorRate;
    private String lastCheckedAt;

    public ApiService() {}

    //Construcutor initializing all fields
    public ApiService(Long id, String name, String ownerTeam, String environment,
                      String status, int averageResponseTimeMs, double errorRate,
                      String lastCheckedAt) {
        this.id = id;
        this.name = name;
        this.ownerTeam = ownerTeam;
        this.environment = environment;
        this.status = status;
        this.averageResponseTimeMs = averageResponseTimeMs;
        this.errorRate = errorRate;
        this.lastCheckedAt = lastCheckedAt;
    }

    //Getters and Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getOwnerTeam() { return ownerTeam; }
    public String getEnvironment() { return environment; }
    public String getStatus() { return status; }
    public int getAverageResponseTimeMs() { return averageResponseTimeMs; }
    public double getErrorRate() { return errorRate; }
    public String getLastCheckedAt() { return lastCheckedAt; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setOwnerTeam(String ownerTeam) { this.ownerTeam = ownerTeam; }
    public void setEnvironment(String environment) { this.environment = environment; }
    public void setStatus(String status) { this.status = status; }
    public void setAverageResponseTimeMs(int averageResponseTimeMs) { this.averageResponseTimeMs = averageResponseTimeMs; }
    public void setErrorRate(double errorRate) { this.errorRate = errorRate; }
    public void setLastCheckedAt(String lastCheckedAt) { this.lastCheckedAt = lastCheckedAt; }
}