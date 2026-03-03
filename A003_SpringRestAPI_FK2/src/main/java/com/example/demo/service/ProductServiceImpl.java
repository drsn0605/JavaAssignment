package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category2;
import com.example.demo.model.Product2;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	
	@Override
	public Product2 create(Product2 product) {
		// TODO Auto-generated method stub
		return repo.save(product);
	}

	@Override
	public List<Product2> view() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product2 update(Product2 p, int id) {
		// TODO Auto-generated method stub
		Product2 pro = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product2","ID",id));
		pro.setName(p.getName());
		pro.setPrice(p.getPrice());
		pro.setQty(p.getQty());
		return repo.save(pro);
	}

	@Override
	public void destroy(int id) {
		// TODO Auto-generated method stub
		Product2 p = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product2","ID",id));
		repo.delete(p);
	}

	@Override
	public Product2 retive(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product2","ID",id));
	}

	@Override
	public List<Product2> getByCategory(Category2 c) {
		// TODO Auto-generated method stub
		return repo.getByCategory(c);
	}

}
