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

@Data
public class JacksonMethods {
    //javaToJson

    public void javaToJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = new Student(1, "pratik", "prs");
        School_ school=new School_(1,"SOS",student);
        String s = objectMapper.writeValueAsString(school);
        System.out.println(s);
    }

    //javaToFile

    public void javaToFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = new Student(1, "om", "abc");
        File file = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\AUg5_SpringProject\\AUg5_SpringProject\\src\\main\\resources\\student.txt");
        objectMapper.writeValue(file, student);
    }

    //jsonToJava

    public void jsonToJava() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\"id\":1,\"name\":\"om\"}";
        Student student = objectMapper.readValue(json, Student.class);
        System.out.println(student);
    }

    //fileToJava

    public void fileToJava() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String file = "C:\\Users\\Sreenivas Bandaru\\Downloads\\AUg5_SpringProject\\AUg5_SpringProject\\src\\main\\resources\\student.txt";
        Student student = objectMapper.readValue(new File(file), Student.class);
        System.out.println(student);
    }

    // studentToDto
    public void studentToStudentDTO() {
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = new Student(1, "Pratik", "prs");
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        StudentDto dto = objectMapper.convertValue(student, StudentDto.class);
        System.out.println(dto);
    }

    //ObjectNode and JsonNode

    public void nodes() throws JsonProcessingException {
        String json = "{\"id\":1,\"name\":\"SOS\",\"student\":{\"id\":1,\"name\":\"pratik\",\"password\":\"prs\"}}\n";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        String id = jsonNode.get("id").asText();
        System.out.println("id="+id);
        JsonNode student = jsonNode.get("student");
        ((ObjectNode) student).put("engine","bs6");
        System.out.println(student);
    }



//    public static void main(String[] args) throws IOException {
//        JacksonMethods jacksonMethods = new JacksonMethods();
////          jacksonMethods.javaToJson();
////          jacksonMethods.javaToFile();
////          jacksonMethods.jsonToJava();
////          jacksonMethods.fileToJava();
////          jacksonMethods.studentToStudentDTO();
////          jacksonMethods.nodes();
//            }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {
    private int id;
    private String name;
    private String password;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class StudentDto {
    private int id;
    private String name;

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class School_{
    private int id;
    private String name;
    private Student student;
}