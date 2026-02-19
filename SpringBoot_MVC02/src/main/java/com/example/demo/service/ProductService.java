package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product2;

public interface ProductService {
	public void addOrUpdate(Product2 product);
	public List<Product2> viewProducts();
	public Product2 getById(int id);
	public void deleteProduct(int id);
}
