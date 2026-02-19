package com.service;

import java.util.List;

import com.model.Product;

public interface ProductService {
	
	public void addOrUpdate(Product product);
	public List<Product> allproduct();
	public Product getId(int id);
	public void deleteProduct(int id);
}
