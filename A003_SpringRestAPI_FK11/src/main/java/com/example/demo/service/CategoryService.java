package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category11;

public interface CategoryService {
	public Category11 create(Category11 cat);
	public List<Category11> list();
	public Category11 update(Category11 c, int id);
	public void destroy(int id);
	public Category11 rerive(int id);
	
}
