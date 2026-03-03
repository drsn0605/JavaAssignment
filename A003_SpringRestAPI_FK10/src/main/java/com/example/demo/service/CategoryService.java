package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category10;

public interface CategoryService {
	public Category10 create(Category10 category);
	public List<Category10> list();
	public Category10 update(int id, Category10 cat);
	public void destroy(int id);
	public Category10 retrive(int id);
}