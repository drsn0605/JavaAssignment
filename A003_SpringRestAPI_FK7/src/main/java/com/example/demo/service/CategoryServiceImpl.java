package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category7;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo repo;
	
	@Override
	public Category7 create(Category7 c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public List<Category7> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Category7 update(Category7 c, int id) {
		Category7 cat = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product7","ID",id));
		cat.setName(c.getName());
		return repo.save(cat);
	}

	@Override
	public void destroy(int id) {
		Category7 cat = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product7","ID",id));
		repo.delete(cat);
	}

	@Override
	public Category7 retrive(int id) {
		Category7 cat = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product7","ID",id));
		return cat;
	}

}
