package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category1;
import com.example.demo.model.Product1;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	
	@Override
	public Product1 create(Product1 p) {
		return repo.save(p);
	}

	@Override
	public List<Product1> view() {
		return repo.findAll();
	}

	@Override
	public Product1 update(Product1 p, int id) {
		Product1 pro = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category1","ID",id));
		pro.setName(p.getName());
		pro.setPrice(p.getPrice());
		pro.setQty(p.getQty());
		return repo.save(pro);
	}

	@Override
	public void destroy(int id) {
		Product1 p = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category1","ID",id));
		repo.delete(p);
	}

	@Override
	public Product1 retrive(int cid) {
		Product1 p = repo.findById(cid).orElseThrow(()-> new ResourceNotFoundException("Category1","ID",cid));
		return p;
	}

	@Override
	public List<Product1> catlist(Category1 c) {
		return repo.findByCategory(c);
	}
	
	

}
