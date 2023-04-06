package com.example.students.service;

import com.example.students.dao.StudentRepository;
import com.example.students.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl  implements  StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student s) {
        return studentRepository.save(s);
    }
    @Override
    public Student updateStudent(Student s) {
        return studentRepository.save(s);
    }
    @Override
    public void deleteStudent(Student s) {
        studentRepository.delete(s);

    }
    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }
    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public Page<Student> getAllStudentsParPage(int page, int size) {
        // TODO Auto-generated method stub
        return studentRepository.findAll(PageRequest.of(page, size));
    }

}
