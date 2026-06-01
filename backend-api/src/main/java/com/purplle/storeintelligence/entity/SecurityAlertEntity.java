package com.purplle.storeintelligence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "security_alerts")
public class SecurityAlertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String entityId;
    private Double employeeProbability;
    private Double customerProbability;
    private Double browsingConfidence;
    private Double suspicionConfidence;
    private String checkoutVerificationStatus;
    private String productTrackingStatus;
    private String currentZone;
    private String riskLevel;
    private LocalDateTime timestamp;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEntityId() { return entityId; }
    public void setEntityId(String entityId) { this.entityId = entityId; }
    public Double getEmployeeProbability() { return employeeProbability; }
    public void setEmployeeProbability(Double employeeProbability) { this.employeeProbability = employeeProbability; }
    public Double getCustomerProbability() { return customerProbability; }
    public void setCustomerProbability(Double customerProbability) { this.customerProbability = customerProbability; }
    public Double getBrowsingConfidence() { return browsingConfidence; }
    public void setBrowsingConfidence(Double browsingConfidence) { this.browsingConfidence = browsingConfidence; }
    public Double getSuspicionConfidence() { return suspicionConfidence; }
    public void setSuspicionConfidence(Double suspicionConfidence) { this.suspicionConfidence = suspicionConfidence; }
    public String getCheckoutVerificationStatus() { return checkoutVerificationStatus; }
    public void setCheckoutVerificationStatus(String checkoutVerificationStatus) { this.checkoutVerificationStatus = checkoutVerificationStatus; }
    public String getProductTrackingStatus() { return productTrackingStatus; }
    public void setProductTrackingStatus(String productTrackingStatus) { this.productTrackingStatus = productTrackingStatus; }
    public String getCurrentZone() { return currentZone; }
    public void setCurrentZone(String currentZone) { this.currentZone = currentZone; }
    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}