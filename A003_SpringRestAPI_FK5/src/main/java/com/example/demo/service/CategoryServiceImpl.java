package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category5;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo repo;
	
	@Override
	public Category5 create(Category5 c) {
		return repo.save(c);
	}

	@Override
	public List<Category5> list() {
		return repo.findAll();
	}

	@Override
	public Category5 update(int id, Category5 c) {
		Category5 cat = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category5","ID",id));
		cat.setName(c.getName());
		return repo.save(cat);
	}

	@Override
	public void destroy(int id) {
		Category5 c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category5","ID",id));
		repo.delete(c);
	}

	@Override
	public Category5 retrive(int id) {
		Category5 c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category5","ID",id));
		return c;
	}

}
