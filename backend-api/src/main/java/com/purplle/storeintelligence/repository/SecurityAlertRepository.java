package com.purplle.storeintelligence.repository;

import com.purplle.storeintelligence.entity.SecurityAlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecurityAlertRepository extends JpaRepository<SecurityAlertEntity, Long> {
    // Custom query to quickly grab the highest risk items for the dashboard
    List<String> findByRiskLevel(String riskLevel);
}
