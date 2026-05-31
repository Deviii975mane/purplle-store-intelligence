package com.purplle.storeintelligence.service;

import com.purplle.storeintelligence.entity.StoreSalesEntity;
import com.purplle.storeintelligence.repository.StoreSalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private StoreSalesRepository repository;

    @Override
    public void run(String... args) throws Exception {
        // Only run this if the database is currently empty!
        if (repository.count() > 0) {
            System.out.println("✅ [Purplle System]: Database already contains data. Skipping ingestion.");
            return;
        }

        System.out.println("⏳ [Purplle System]: Commencing automated data ingestion from CSV...");
        
        List<StoreSalesEntity> batch = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new ClassPathResource("dataset.csv").getInputStream()))) {
            
            String line;
            boolean isFirstRow = true;
            
            while ((line = br.readLine()) != null) {
                // Skip the header row
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                // Handle standard CSV splitting 
                String[] data = line.split(",", -1);
                if (data.length < 39) continue; // Skip malformed rows

                StoreSalesEntity entity = new StoreSalesEntity();
                entity.setOrderId(data[0]);
                entity.setCouponCode(data[1]);
                entity.setOfferName(data[2]);
                entity.setDiscountCode(data[3]);
                entity.setInvoiceNumber(data[4]);
                entity.setInvoiceType(data[5]);
                entity.setOrderDate(data[6]);
                entity.setOrderTime(data[7]);
                entity.setReturnId(data[8]);
                entity.setStoreId(data[9]);
                entity.setStoreName(data[10]);
                entity.setCity(data[11]);
                entity.setCustomerName(data[12]);
                entity.setCustomerNumber(data[13]);
                entity.setSku(data[14]);
                entity.setProductId(data[15]);
                entity.setEan(data[16]);
                entity.setProductName(data[17]);
                entity.setBrandName(data[18]);
                entity.setDepName(data[19]);
                entity.setSubCategory(data[20]);
                entity.setBrandType(data[21]);
                entity.setTax(parseBd(data[22]));
                entity.setHsnCode(data[23]);
                entity.setSalespersonId(data[24]);
                entity.setEmployeeCode(data[25]);
                entity.setSalespersonName(data[26]);
                entity.setQty(parseInt(data[27]));
                entity.setGmv(parseBd(data[28]));
                entity.setNmv(parseBd(data[29]));
                entity.setCouponAmount(parseBd(data[30]));
                entity.setItemPromotion(parseBd(data[31]));
                entity.setAmtWithoutGwp(parseBd(data[32]));
                entity.setTotalAmount(parseBd(data[33]));
                entity.setPbEbSale(data[34]);
                entity.setWeekAssigned(data[35]);
                entity.setTaxM(parseBd(data[36]));
                entity.setTaxableAmt(parseBd(data[37]));
                entity.setTaxAmt(parseBd(data[38]));

                batch.add(entity);
            }
            
            // Save all rows to PostgreSQL at once for maximum performance
            repository.saveAll(batch);
            System.out.println("🚀 [Purplle System]: Successfully ingested " + batch.size() + " sales records into PostgreSQL!");

        } catch (Exception e) {
            System.err.println("❌ [Purplle System]: Error reading dataset.csv. Make sure the file exists in the resources folder!");
            e.printStackTrace();
        }
    }

    // Helper method to safely convert CSV text to Java Decimals
    private BigDecimal parseBd(String val) {
        return (val == null || val.trim().isEmpty()) ? BigDecimal.ZERO : new BigDecimal(val.trim());
    }

    // Helper method to safely convert CSV text to Java Integers
    private Integer parseInt(String val) {
        return (val == null || val.trim().isEmpty()) ? 0 : Integer.parseInt(val.trim());
    }
}
