package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product5;

public interface ProductService {
	
	public void addOrUpdate(Product5 product);
	public List<Product5> viewProducts();
	public void deleteProduct(int id);
	public Product5 getById(int id);

}
