package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Category1;
import com.example.demo.model.Product1;

public interface ProductRepo extends JpaRepository<Product1, Integer> {

	public List<Product1> findByCategory(Category1 c);

}
