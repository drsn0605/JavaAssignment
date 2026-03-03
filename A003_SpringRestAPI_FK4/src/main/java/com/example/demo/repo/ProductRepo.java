package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Category4;
import com.example.demo.model.Product4;

public interface ProductRepo extends JpaRepository<Product4, Integer>{
	public List<Product4> getByCategory(Category4 c);
}
