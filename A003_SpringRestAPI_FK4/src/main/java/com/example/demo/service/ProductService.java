package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category4;
import com.example.demo.model.Product4;

public interface ProductService {
	public Product4 create(Product4 p);
	public List<Product4> list();
	public Product4 update(Product4 p, int id);
	public void destroy(int id);
	public Product4 retrive(int id);
	public List<Product4> getByCategory(Category4 c);
}
