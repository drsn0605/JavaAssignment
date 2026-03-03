package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category10;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo repo;
	
	@Override
	public Category10 create(Category10 category) {
		// TODO Auto-generated method stub
		return repo.save(category);
	}

	@Override
	public List<Category10> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Category10 update(int id, Category10 cat) {
		Category10 c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category10","ID",id));
		c.setName(cat.getName());
		return repo.save(c);
	}

	@Override
	public void destroy(int id) {
		Category10 c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category10","ID",id));
		repo.delete(c);
		
	}

	@Override
	public Category10 retrive(int id) {
		Category10 c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category10","ID",id));
		return c;
	}

}
