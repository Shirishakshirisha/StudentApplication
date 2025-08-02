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
    
    public Optional<Student> getStudentById(int id){
        return repository.findById(id);
    }

    public void deleteStudent(int id){
        repository.deleteById(id);
    }

    public Student updateStudent(Student student){
        Optional<Student> existing = repository.findById(student.getId());
        if(existing.isPresent()){
            Student update = existing.get();
            update.setName(student.getName());
            return repository.save(update);
        }
        else{
            throw new RuntimeException("Student not found with id:"+student.getId());
        }

    }

}
