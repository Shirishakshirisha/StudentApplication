package com.practice.demo.service;
import java.util.*;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.demo.entities.Student;
import com.practice.demo.repository.StudentRepository;

@Service
public class StudentService {

     private final StudentRepository repository;

   public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    public List<Student> getAllStudents(){
        return repository.findAll();
    }
    public Student saveStudent(Student student){
        return repository.save(student);
    }

}
