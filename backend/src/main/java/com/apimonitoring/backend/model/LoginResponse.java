package com.apimonitoring.backend.model;

public class LoginResponse {
    private String message;
    private boolean authenticated;
    private String token;

    public LoginResponse() {

    }

    public LoginResponse(String message, boolean authenticated, String token) {
        this.message = message;
        this.authenticated = authenticated;
        this.token = token;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
