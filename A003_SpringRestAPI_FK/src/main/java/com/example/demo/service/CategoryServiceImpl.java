package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo repo;
	
	@Override
	public Category create(Category c) {
		return repo.save(c);
	}

	@Override
	public List<Category> list() {
		return repo.findAll();
	}

	@Override
	public Category retrive(int cid) {
		Category c = repo.findById(cid).orElseThrow(()-> new ResourceNotFoundException("Category","ID",cid));
		return c;
	}

	@Override
	public Category update(Category c, int id) {
		Category uc = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","ID",id));
		uc.setName(c.getName());
		return repo.save(uc);
	}

	@Override
	public void destroy(int id) {
		Category dc = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","ID",id));
		repo.delete(dc);
	}

}
