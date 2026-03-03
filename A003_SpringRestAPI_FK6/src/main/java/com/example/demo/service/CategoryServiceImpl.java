package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category6;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo repo;
	
	@Override
	public Category6 create(Category6 c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public List<Category6> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Category6 update(int id, Category6 cat) {
		Category6 c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category6","ID",id));
		c.setName(cat.getName());
		return repo.save(c);
	}

	@Override
	public void destroy(int id) {
		// TODO Auto-generated method stub
		Category6 c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category6","ID",id));
		repo.delete(c);
	}

	@Override
	public Category6 retrive(int id) {
		Category6 c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category6","ID",id));
		return c;
	}

}
