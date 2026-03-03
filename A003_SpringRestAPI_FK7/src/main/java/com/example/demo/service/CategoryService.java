package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category7;

public interface CategoryService {
	public Category7 create(Category7 c);
	public List<Category7> list();
	public Category7 update(Category7 c, int id);
	public void destroy(int id);
	public Category7 retrive(int id);
}
