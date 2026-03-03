package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category5;

public interface CategoryService {
	public Category5 create(Category5 c);
	public List<Category5> list();
	public Category5 update(int id, Category5 c);
	public void destroy(int id);
	public Category5 retrive(int id);
}
