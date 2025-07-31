package com.practice.demo.controller;

import java.util.List;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.entities.Student;
import com.practice.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service){
        this.service=service;
    }

   @GetMapping
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

}
