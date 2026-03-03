package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category8;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo repo;
	
	@Override
	public Category8 create(Category8 cat) {
		// TODO Auto-generated method stub
		return repo.save(cat);
	}

	@Override
	public List<Category8> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Category8 update(Category8 cat, int id) {
		Category8 c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category8","ID",id));
		c.setName(cat.getName());
		return repo.save(c);
	}

	@Override
	public void destroy(int id) {
		Category8 c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category8","ID",id));
		repo.delete(c);
	}

	@Override
	public Category8 retrive(int id) {
		Category8 c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category8","ID",id));
		return c;
	}

}
