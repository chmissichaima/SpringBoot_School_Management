package com.example.students;

import com.example.students.dao.StudentRepository;
import com.example.students.entites.Student;
import com.example.students.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

import static org.aspectj.bridge.MessageUtil.fail;

@SpringBootTest
class GestionSchoolApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService service;




    @Test
    public void testCreateStudent() {
        Student stud= new Student ("chaime","ch@gmail.com","123");
        studentRepository.save(stud);
    }

    @Test
    public void testFindStudent()
    {
        Optional<Student> optionalStudent = studentRepository.findById(1L);
        if (optionalStudent.isPresent()) {
            Student s = optionalStudent.get();
            System.out.println(s);
        } else {
            System.out.println("Student not found");
        }
    }

    @Test
    public void testUpdateStudent()
    {
        Optional<Student> optionalStudent = studentRepository.findById(1L);
        if (optionalStudent.isPresent()) {
            Student s = optionalStudent.get();
            s.setPassword("kjgf");
            studentRepository.save(s);

            System.out.println(s);
        } else {
            System.out.println("Student not found");
        }
    }

    @Test
    public void testDeleteStudent() {
        Optional<Student> studentOptional = studentRepository.findById(1L);
        if (studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
        } else {
            fail("Student with id 1 not found");
        }
    }

    @Test
    public void testFindAllStudents()
    {
        List<Student> studs = studentRepository.findAll();

        for (Student s:studs)
            System.out.println(s);

    }

    @Test
    public void testFindByNomStudentContains()
    {
        Page<Student> prods = service.getAllStudentsParPage(0,2);
        System.out.println(prods.getSize());
        System.out.println(prods.getTotalElements());

        System.out.println(prods.getTotalPages());
        prods.getContent().forEach(p -> {System.out.println(p.toString());});
    }



}
