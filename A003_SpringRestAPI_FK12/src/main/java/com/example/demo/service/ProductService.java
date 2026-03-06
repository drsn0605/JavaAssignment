package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product12;

public interface ProductService {
	public Product12 create(Product12 p);
	public List<Product12> list();
	public Product12 update(Product12 p, int id);
	public void destroy(int id);
	public Product12 retrive(int id);
	
}
