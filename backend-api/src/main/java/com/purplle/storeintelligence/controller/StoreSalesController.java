package com.purplle.storeintelligence.controller;

import com.purplle.storeintelligence.entity.StoreSalesEntity;
import com.purplle.storeintelligence.repository.StoreSalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StoreSalesController {

    @Autowired
    private StoreSalesRepository repository;

    // 1. The Acceptance Gate Checker
    @GetMapping("/system/health")
    public String healthCheck() {
        return "Purplle Store Intelligence API is LIVE and successfully connected to the PostgreSQL Database!";
    }

    // 2. The Data Retrieval Endpoint
    @GetMapping("/metrics/sales")
    public List<StoreSalesEntity> getRecentSales() {
        // We limit to 50 so the browser doesn't crash if they load a massive CSV later
        return repository.findAll().stream().limit(50).toList();
    }
}