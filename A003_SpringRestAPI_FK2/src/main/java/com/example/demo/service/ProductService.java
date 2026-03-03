package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category2;
import com.example.demo.model.Product2;

public interface ProductService {
	public Product2 create(Product2 product);
	public List<Product2> view();
	public Product2 update(Product2 p, int id);
	public void destroy(int id);
	public Product2 retive(int id);  //may be cid
	public List<Product2> getByCategory(Category2 c);
}
