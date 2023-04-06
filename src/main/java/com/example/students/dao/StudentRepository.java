package com.example.students.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.students.entites.Student;
public interface StudentRepository extends JpaRepository<Student, Long> {


}
