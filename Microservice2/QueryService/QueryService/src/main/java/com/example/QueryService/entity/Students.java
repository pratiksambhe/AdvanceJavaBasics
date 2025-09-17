package com.example.QueryService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {

    @Id
    @SequenceGenerator(name = "student_seq123",initialValue = 1,allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq123")
    private Integer id;

    private String name;
    private String city;

}
