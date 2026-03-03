package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category1;
import com.example.demo.model.Product1;

public interface ProductService {
	public Product1 create(Product1 p);
	public List<Product1> view();
	public Product1 update(Product1 p, int id);
	public void destroy(int id);
	public Product1 retrive(int cid);
	public List<Product1> catlist(Category1 c);
}
