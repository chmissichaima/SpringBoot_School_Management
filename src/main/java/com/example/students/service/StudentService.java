package com.example.students.service;

import com.example.students.entites.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student s);
    Student updateStudent(Student s);
    void deleteStudent(Student S);
    void deleteStudentById(Long id);
    Student getStudent(Long id);
    List<Student> getAllStudents();
    Page<Student> getAllStudentsParPage(int page, int size);
}
