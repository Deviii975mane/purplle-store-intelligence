package com.purplle.storeintelligence.repository;

import com.purplle.storeintelligence.entity.StoreSalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreSalesRepository extends JpaRepository<StoreSalesEntity, Long> {
    // By simply extending JpaRepository, Spring Boot automatically generates 
    // all the SQL for inserting, finding, and deleting data for us!
}
