package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category1;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepo repo;
	
	@Override
	public Category1 create(Category1 c) {
		return repo.save(c);
	}

	@Override
	public List<Category1> view() {
		return repo.findAll();
	}

	@Override
	public Category1 update(Category1 c, int id) {
		Category1 cat = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category1","ID",id));
		cat.setName(c.getName());
		return repo.save(cat);
	}

	@Override
	public void destroy(int id) {
		Category1 c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category1","ID",id));
		repo.delete(c);
	}

	@Override
	public Category1 retrive(int cid) {
		Category1 cat = repo.findById(cid).orElseThrow(()-> new ResourceNotFoundException("Category1","ID",cid));
		return cat;
	}

}
