package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Product2;

public interface ProductRepo extends JpaRepository<Product2, Integer> {

}
