package com.apimonitoring.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apimonitoring.backend.model.ApiService;

//This provides CRUD operations for our API Service
@Repository
public interface ApiServiceRepository extends JpaRepository<ApiService, Long> {
    
}
