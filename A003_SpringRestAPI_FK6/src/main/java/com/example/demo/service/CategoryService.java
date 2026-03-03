package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category6;

public interface CategoryService {
	public Category6 create(Category6 c);
	public List<Category6> list();
	public Category6 update(int id, Category6 cat);
	public void destroy(int id);
	public Category6 retrive(int id);
}
