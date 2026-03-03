package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category4;

public interface CategoryService {
	public Category4 create(Category4 c);  //create - c
	public List<Category4> list();   //read - r
	public Category4 update(Category4 c,int id);   //update - u
 	public void destroy(int id);   //delete - d
 	public Category4 retrive(int id);
}
