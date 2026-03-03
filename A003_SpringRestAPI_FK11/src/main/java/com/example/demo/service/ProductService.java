package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product11;

public interface ProductService {
	public Product11 create(Product11 pro);
	public List<Product11> list();
	public Product11 update(Product11 p, int id);
	public void destroy(int id);
	public Product11 retrive(int id);
	
}
