package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category3;

public interface CategoryService {
	public Category3 create(Category3 c);
	public List<Category3> view();
	public Category3 update(Category3 cat, int id);
	public void destroy(int id);
	public Category3 retrive(int id);
}
