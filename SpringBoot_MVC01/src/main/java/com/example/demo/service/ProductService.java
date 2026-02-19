package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	public void addOrUpdateStudent(Product product);
	public List<Product> viewProducts();
	public Product getProduct(int id);
	public void deleteProduct(int id);
}
