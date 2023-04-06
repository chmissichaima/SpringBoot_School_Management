package com.example.students;

import com.example.students.entites.Student;
import com.example.students.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class GestionSchoolApplication implements CommandLineRunner {
    @Autowired
    private StudentServiceImpl service;
    public static void main(String[] args) {
        SpringApplication.run(GestionSchoolApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        Student stud1 = new Student("Salme","salma123@gmail.com","1122");
        Student stud2 = new Student("Rihab","rihab4@gmail.com","ghg");
        service.saveStudent(stud1);
        service.saveStudent(stud2);

    }

}

