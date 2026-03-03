package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Category1;

public interface CategoryRepo extends JpaRepository<Category1, Integer> {

}
