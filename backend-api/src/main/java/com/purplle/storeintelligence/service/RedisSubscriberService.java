package com.purplle.storeintelligence.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purplle.storeintelligence.entity.SecurityAlertEntity;
import com.purplle.storeintelligence.repository.SecurityAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RedisSubscriberService implements MessageListener {

    @Autowired
    private SecurityAlertRepository alertRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            // 1. Read the JSON from Python
            String jsonPayload = new String(message.getBody());
            System.out.println("📥 [Redis Listener] Caught AI Alert: " + jsonPayload);

            // 2. Parse the JSON safely
            JsonNode node = objectMapper.readTree(jsonPayload);
            
            // 3. Map it to our Database Entity
            SecurityAlertEntity alert = new SecurityAlertEntity();
            alert.setEntityId(node.has("entity_id") ? node.get("entity_id").asText() : "UNKNOWN");
            alert.setEmployeeProbability(node.get("employee_probability").asDouble());
            alert.setCustomerProbability(node.get("customer_probability").asDouble());
            alert.setBrowsingConfidence(node.get("browsing_confidence").asDouble());
            alert.setSuspicionConfidence(node.get("suspicion_confidence").asDouble());
            alert.setCheckoutVerificationStatus(node.get("checkout_verification_status").asText());
            alert.setProductTrackingStatus(node.get("product_tracking_status").asText());
            alert.setCurrentZone(node.get("current_zone").asText());
            alert.setRiskLevel(node.get("risk_level").asText());
            
            // Stamp exactly when it arrived in the Java Database Layer
            alert.setTimestamp(LocalDateTime.now());

            // 4. Save to PostgreSQL
            alertRepository.save(alert);
            System.out.println("💾 [Redis Listener] Alert successfully committed to PostgreSQL!");

        } catch (Exception e) {
            System.err.println("❌ [Redis Listener] Failed to process alert from AI: " + e.getMessage());
        }
    }
}