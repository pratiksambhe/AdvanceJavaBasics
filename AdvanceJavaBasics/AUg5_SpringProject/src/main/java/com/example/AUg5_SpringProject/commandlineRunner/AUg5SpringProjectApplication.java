//package com.example.AUg5_SpringProject.commandlineRunner;
//
//import com.example.AUg5_SpringProject.entityOracle.Student;
//import com.example.AUg5_SpringProject.repoOracle.StudentRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class AUg5SpringProjectApplication implements CommandLineRunner {
//
//	@Autowired
//	StudentRepo studentRepo;
//
//	@Override
//	public void run(String[]args){
//		Student student=new Student(1,"Pratik","PRMCEAM");
//		studentRepo.save(student);
//	}
//
////	public static void main(String[] args) {
////		SpringApplication.run(AUg5SpringProjectApplication.class, args);
////	}
//
//}
