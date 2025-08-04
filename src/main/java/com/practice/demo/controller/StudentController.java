package com.practice.demo.controller;

import java.util.*;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.entities.Student;
import com.practice.demo.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken)request.getAttribute("_csrf");

    }

   @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = service.getAllStudents();
        return  ResponseEntity.ok(students);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student savedStudent = service.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        Optional<Student> student = service.getStudentById(id);
        return student.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        service.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
        student.setId(id);
        Student updatedStudent = service.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }
}
