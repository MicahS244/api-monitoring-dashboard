package com.apimonitoring.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apimonitoring.backend.model.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
    
}
