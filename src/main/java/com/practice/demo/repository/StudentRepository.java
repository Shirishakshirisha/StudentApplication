package com.practice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.demo.entities.Student;

public interface StudentRepository extends JpaRepository<Student , Integer>{


}
