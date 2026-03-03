package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product3;

public interface ProductService {
	public Product3 create(Product3 p);
	public List<Product3> view();
	public Product3 update(Product3 pro,int id);
	public void destroy(int id);
	public Product3 retrive(int cid);
}
