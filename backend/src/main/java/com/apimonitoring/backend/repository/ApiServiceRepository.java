package com.apimonitoring.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apimonitoring.backend.model.ApiService;

@Repository
public interface ApiServiceRepository extends JpaRepository<ApiService, Long> {
    
}
