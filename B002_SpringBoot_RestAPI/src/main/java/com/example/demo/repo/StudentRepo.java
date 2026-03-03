package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Student2;

public interface StudentRepo extends JpaRepository<Student2, Integer> {

}
