package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product4;

public interface ProductService {
	
	public void addOrUpdate(Product4 product);
	public List<Product4> viewProduct();
	public Product4 getById(int id);
	public void deleteProduct(int id);
	
}
