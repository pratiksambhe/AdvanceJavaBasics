package com.example.AUg5_SpringProject.repoMysql;

import com.example.AUg5_SpringProject.entityMysql.AadharCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AadharCardRepo extends JpaRepository<AadharCard,Integer> {
}
