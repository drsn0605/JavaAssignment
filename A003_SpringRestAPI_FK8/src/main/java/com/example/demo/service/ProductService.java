package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product8;

public interface ProductService {
	public Product8 create(Product8 pro);
	public List<Product8> list();
	public Product8 update(Product8 pro, int id);
	public void destroy(int id);
	public Product8 retrive(int id);
}
