package com.example.AUg5_SpringProject.repoMysql;

import com.example.AUg5_SpringProject.entityMysql.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person,Integer> {
}
