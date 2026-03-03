package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	public Product create(Product p);
	public List<Product> list();
	public Product update(Product p, int id);
	public void destroy(int id);
	public Product retrive(int cid);
}
