package com.example.AUg5_SpringProject.designPattern.creational.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User1 {
    private int id;
    private String name;
}
