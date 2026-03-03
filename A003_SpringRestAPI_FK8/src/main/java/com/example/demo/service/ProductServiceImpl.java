package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product8;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	
	@Override
	public Product8 create(Product8 pro) {
		// TODO Auto-generated method stub
		return repo.save(pro);
	}

	@Override
	public List<Product8> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product8 update(Product8 pro, int id) {
		Product8 p = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product8","ID",id));
		p.setName(pro.getName());
		p.setPrice(pro.getPrice());
		p.setQty(pro.getQty());
		p.setCategory(pro.getCategory());
		return repo.save(p);
	}

	@Override
	public void destroy(int id) {
		Product8 p = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product8","ID",id));
		repo.delete(p);
	}

	@Override
	public Product8 retrive(int id) {
		Product8 p = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product8","ID",id));
		return p;
	}

}
