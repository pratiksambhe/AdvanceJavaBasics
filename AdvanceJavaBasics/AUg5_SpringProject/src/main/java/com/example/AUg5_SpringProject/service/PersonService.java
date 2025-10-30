package com.example.AUg5_SpringProject.service;

import com.example.AUg5_SpringProject.Exception.InvalidDataException;
import com.example.AUg5_SpringProject.entityMysql.Person;
import com.example.AUg5_SpringProject.entityMysql.Vehicle;
import com.example.AUg5_SpringProject.repoMysql.PersonRepo;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepo personRepo;

    public PersonService(PersonRepo personRepo){
        this.personRepo=personRepo;
    }

    //add Person
    public Person addPerson(Person person){
        String query="Select * from Person where id=";
        if(person.getId()!=null){
            throw new InvalidDataException();
        }
        for(Vehicle v: person.getVehicleList()){
                v.setPerson(person);
            }
        return personRepo.save(person);
    }
}
