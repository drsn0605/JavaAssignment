package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category12;

public interface CategoryService {
	public Category12 create(Category12 c);
	public List<Category12> list();
	public Category12 update(Category12 c, int id);
	public void destroy(int id);
	public Category12 retrive(int id);
	
}
