package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product10;

public interface ProductService {
	public Product10 create(Product10 product);
	public List<Product10> list();
	public Product10 update(int id, Product10 pro);
	public void destroy(int id);
	public Product10 retrive(int id);
	
}
