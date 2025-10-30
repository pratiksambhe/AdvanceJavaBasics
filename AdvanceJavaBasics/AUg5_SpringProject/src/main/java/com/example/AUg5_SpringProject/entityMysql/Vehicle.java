package com.example.AUg5_SpringProject.entityMysql;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class



Vehicle {

    @Id
    @SequenceGenerator(name = "vehical_seq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "vehical_seq")
    private Integer id;
    private Integer count;
    private String numberPlate;
    private String color;
//    @Enumerated(EnumType.STRING)
//    private VehicleType vehicleType;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
