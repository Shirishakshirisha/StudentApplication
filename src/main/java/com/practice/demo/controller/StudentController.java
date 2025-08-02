package com.practice.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.entities.Student;
import com.practice.demo.service.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

//Marks the java class as a Restfull web service controller
//RestController is a combination of @Controller and Response body
//So every method in that class returns a JSON or XML response 
@RestController
//To define the url path
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

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable int id){
        return service.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        service.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student){
        student.setId(id);
        return service.updateStudent(student);
    }
}
