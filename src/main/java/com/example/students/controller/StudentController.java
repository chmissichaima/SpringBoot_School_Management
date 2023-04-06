package com.example.students.controller;

import com.example.students.dao.StudentRepository;
import com.example.students.entites.Student;
import com.example.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping("/showCreate")
    public String showCreate()
    {
        return "createStudent";
    }
    @RequestMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student,
                              ModelMap modelMap) throws ParseException
    {

        Student saveStudent = studentService.saveStudent(student);
        String msg ="student saved with Id "+saveStudent.getId();
        modelMap.addAttribute("msg", msg);
        return "createStudent";
    }
    @RequestMapping("/listeStudents")
    public String listeStudents(ModelMap modelMap,@RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "2") int size)
    {
        Page<Student> studs = studentService.getAllStudentsParPage(page, size);
        modelMap.addAttribute("students", studs);
        modelMap.addAttribute("pages", new int[studs.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeStudents";
    }


    @RequestMapping("/supprimerStudent")
    public String supprimerStudent(@RequestParam("id") Long id, ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "2") int size)
    {
        studentService.deleteStudentById(id);
        Page<Student> studs = studentService.getAllStudentsParPage(page, size);
        modelMap.addAttribute("students", studs);
        modelMap.addAttribute("pages", new int[studs.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeStudents";
    }



    @RequestMapping("/modifierStudent")
    public String editerStudent(@RequestParam("id") Long id,ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "2") int size)
    {
        Student s = studentService.getStudent(id);
        modelMap.addAttribute("student", s);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "editStudent";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(@ModelAttribute("student") Student student,

                                ModelMap modelMap,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "2") int size) throws ParseException
    {

        studentService.updateStudent(student);
        Page<Student> studs = studentService.getAllStudentsParPage(page, size);
        modelMap.addAttribute("students", studs);
        modelMap.addAttribute("pages", new int[studs.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);

        return "listeStudents";
    }


}





