package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category2;
import com.example.demo.model.Product2;

public interface CategoryService {
	public Category2  create(Category2 category);
	public List<Category2> list();
	public Category2 update(Category2 c, int id);
	public void destroy(int id);
	public Category2 retrive(int cid);
}
