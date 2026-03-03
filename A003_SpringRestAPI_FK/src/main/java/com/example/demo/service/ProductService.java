package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category;
import com.example.demo.model.Product;

public interface ProductService{
	public Product create(Product p);
	public List<Product> list();
	public Product retrive(int cid);
	public Product update(Product p, int id);
	public void destroy(int id);
	public List<Product> catlist(Category c);
}
