package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo repo;
	
	@Override
	public Category create(Category c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Category update(Category c, int id) {
		Category cat = repo.findById(id).orElseThrow();
		cat.setName(c.getName());
		return cat;
	}

	@Override
	public void destroy(int id) {
		Category cat = repo.findById(id).orElseThrow();
		repo.delete(cat);
	}

	@Override
	public Category retrive(int cid) {
		Category cat = repo.findById(cid).orElseThrow();
		return cat;
	}

}
