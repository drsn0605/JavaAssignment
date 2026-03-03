package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Student3;

public interface StudentRepo extends JpaRepository<Student3, Integer> {

}
