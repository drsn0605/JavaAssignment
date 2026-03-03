package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product5;

public interface ProductService {
	public Product5 create(Product5 p);
	public List<Product5> list();
	public Product5 update(int id,Product5 p);
	public void destroy(int id);
	public Product5 retrive(int id);
}
