package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Category2;
import com.example.demo.model.Product2;

public interface ProductRepo extends JpaRepository<Product2, Integer>{

	public List<Product2> getByCategory(Category2 c);
}
