package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Category3;
import com.example.demo.model.Product3;

public interface ProductRepo extends JpaRepository<Product3,Integer>{
	public Category3 getCategory(Category3 cat);
}
