package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	
	@Override
	public Product create(Product p) {
		return repo.save(p);
	}

	@Override
	public List<Product> list() {
		return repo.findAll();
	}

	@Override
	public Product retrive(int cid) {
		Product p = repo.findById(cid).orElseThrow(()-> new ResourceNotFoundException("Product","ID",cid));
		return p;
	}

	@Override
	public Product update(Product p, int id) {
		Product up = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product","ID",id));
		return repo.save(up);
	}

	@Override
	public void destroy(int id) {
		Product dp = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product","ID",id));
		repo.delete(dp);
	}

	@Override
	public List<Product> catlist(Category c) {
		return repo.findByCategory(c);
	}

}
