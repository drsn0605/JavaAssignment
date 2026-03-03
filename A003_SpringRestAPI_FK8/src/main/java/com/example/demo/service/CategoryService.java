package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category8;

public interface CategoryService {
	public Category8 create(Category8 cat);
	public List<Category8> list();
	public Category8 update(Category8 cat, int id);
	public void destroy(int id);
	public Category8 retrive(int id);
	
}
