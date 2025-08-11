package com.example.AUg5_SpringProject.repoOracle;

import com.example.AUg5_SpringProject.entityOracle.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

}
