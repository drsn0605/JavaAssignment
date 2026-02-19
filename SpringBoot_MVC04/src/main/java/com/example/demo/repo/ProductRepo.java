package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Product4;

public interface ProductRepo extends JpaRepository<Product4, Integer> {

}
