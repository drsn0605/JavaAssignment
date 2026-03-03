package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product6;

public interface ProductService {
	public Product6 create(Product6 p);
	public List<Product6> list();
	public Product6 update(int id, Product6 pro);
	public void destroy(int id);
	public Product6 retrive(int id);
}
