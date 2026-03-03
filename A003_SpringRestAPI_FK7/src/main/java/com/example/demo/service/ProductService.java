package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product7;

public interface ProductService {
	public Product7 create(Product7 p);
	public List<Product7> list();
	public Product7 update(Product7 p, int id);
	public void destroy(int id);
	public Product7 retrive(int id);
	
}
