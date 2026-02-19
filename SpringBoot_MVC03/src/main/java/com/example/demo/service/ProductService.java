package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product3;

public interface ProductService {
	public void addOrUpdate(Product3 product);
	public List<Product3> viewProducts();
	public void deleteProduct(int id);
	public Product3 getProductById(int id);
	
}
