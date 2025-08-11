package com.example.AUg5_SpringProject.repoMysql;

import com.example.AUg5_SpringProject.entityMysql.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle,Integer> {
}
