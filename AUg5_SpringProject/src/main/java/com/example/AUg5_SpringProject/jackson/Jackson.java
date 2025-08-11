package com.example.AUg5_SpringProject.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;

public class Jackson {
    //java To Json
    public void javaToJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Student1 student = new Student1(1, "shreyash", "2");
        School school=new School(1,"SOS",student);
        String s = objectMapper.writeValueAsString(school);
        System.out.println(s);
    }

    //json To Java

    public void jsonToJava() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\"id\":1,\"name\":\"shreyash\",\"password\":\"2\"}\n";
        Student1 student = objectMapper.readValue(json, Student1.class);
        System.out.println(student);
    }

    //java to file

    public void javaToFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Student1 student = new Student1(1, "Pratik", "2");
        File file = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\AUg5_SpringProject\\AUg5_SpringProject\\src\\main\\resources\\student.txt");
        objectMapper.writeValue(file, student);

    }

    //file to java
    public void fileToJava() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String file = "C:\\Users\\Sreenivas Bandaru\\Downloads\\AUg5_SpringProject\\AUg5_SpringProject\\src\\main\\resources\\student.txt";
        Student1 student1 = objectMapper.readValue(new File(file), Student1.class);
        System.out.println(student1);
    }

    //student to Dto
    public void studentToDTO(){
        ObjectMapper objectMapper=new ObjectMapper();
        Student1 student1= new Student1(1,"Pratik","2");
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        Student1DTO student1DTO = objectMapper.convertValue(student1, Student1DTO.class);
        System.out.println(student1DTO);
    }

    //JSonNode or ObjectNode
    public void check() throws JsonProcessingException {
        String json="{\"id\":1,\"sclName\":\"SOS\",\"student1\":{\"id\":1,\"name\":\"shreyash\",\"std\":\"2\"}}";
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        JsonNode student1 = jsonNode.get("student1");
        System.out.println(student1);
        ((ObjectNode)student1).put("marks",50);
        System.out.println(student1);
        ((ObjectNode)student1).remove("name");
        System.out.println(student1);
        JsonNode id = jsonNode.get("id");
        ((ObjectNode)student1).set("ids",id );
        System.out.println(student1);
        ((ObjectNode)student1).set("ids",id );

    }


//    public static void main(String[] args) throws IOException {
//        Jackson jackson = new Jackson();
//        jackson.check();
//    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class School{
    private  int id;
    private  String sclName;
    private Student1 student1;

}



@Data
@AllArgsConstructor
@NoArgsConstructor
class Student1 {
    private int id;
    private String name;
    private String std;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student1DTO{
    private  int id;
    private  String name;
}