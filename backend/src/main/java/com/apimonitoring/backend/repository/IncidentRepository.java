package com.apimonitoring.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apimonitoring.backend.model.Incident;

//This provides CRUD operations for our Incident Service 
@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
    
}
