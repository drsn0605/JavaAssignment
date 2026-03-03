package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category11;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CategoryRepo;

@Service	
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo repo;
	
	@Override
	public Category11 create(Category11 cat) {
		// TODO Auto-generated method stub
		return repo.save(cat);
	}

	@Override
	public List<Category11> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Category11 update(Category11 c, int id) {
		Category11 cat = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category11","ID",id));
		cat.setName(c.getName());
		return repo.save(cat);
	}

	@Override
	public void destroy(int id) {
		Category11 cat = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category11","ID",id));
		repo.delete(cat);
	}

	@Override
	public Category11 rerive(int id) {
		Category11 cat = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category11","ID",id));
		return cat;
	}

}
