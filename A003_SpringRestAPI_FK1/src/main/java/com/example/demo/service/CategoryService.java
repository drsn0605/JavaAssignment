package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category1;

public interface CategoryService {
	public Category1 create(Category1 c);
	public List<Category1> view();
	public Category1 update(Category1 c, int id);
	public void destroy(int id);
	public Category1 retrive(int cid);
}
