package com.example.question_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persons {


    @Id
    @SequenceGenerator(name = "person_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "person_seq")
    private Integer id;

    private String name;

    private String city;


}
