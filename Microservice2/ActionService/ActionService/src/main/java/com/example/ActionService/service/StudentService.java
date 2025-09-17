package com.example.ActionService.service;

import com.example.ActionService.dto.StudnetDto;
import com.example.ActionService.entity.Students;
import com.example.ActionService.repo.FeignQuery;
import com.example.ActionService.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private FeignQuery feignQuery;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder builder;


    public Students getStudentById(Integer id) {
        return studentRepo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Students> getAll() {
        return studentRepo.findAll();
    }

    public Students addStudent(StudnetDto studnetDto) {
        Students students = new Students();
        students.setCity(studnetDto.getCity());
        students.setName(studnetDto.getName());
        studentRepo.save(students);
        return students;
    }

    public Students updateCityStudentByName(Integer id, String city) {
        Students students = studentRepo.findById(id).orElseThrow(() -> new RuntimeException());
        students.setCity(city);
        return students;
    }

    public Students updateStudentById(Integer id, StudnetDto studnetDto) {

        Students student = feignQuery.getStudentById(id);
        if (student != null) {
            student.setName(studnetDto.getName());
            student.setCity(studnetDto.getCity());
            studentRepo.save(student);
            return student;
        } else {
            throw new RuntimeException("invalid Id");
        }
    }

    public Students getByRestTemplete(Integer id) {
        String url = "http://localhost:8094/student/getById/" + id;
        System.out.println(1);

        return restTemplate.getForObject(url, Students.class);
    }

    public Students getByWebClient(Integer id) {
        return builder.build().
                get()
                .uri("http://QUERYSERVICE/student/getById/{id}", id)  // service name from Eureka
                .retrieve()
                .bodyToMono(Students.class)   // async reactive call
                .block();
    }
}
