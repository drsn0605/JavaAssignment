package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product7;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	
	@Override
	public Product7 create(Product7 p) {
		// TODO Auto-generated method stub
		return repo.save(p);
	}

	@Override
	public List<Product7> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product7 update(Product7 p, int id) {
		Product7 pro = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product7","ID",id));
		pro.setName(p.getName());
		pro.setPrice(p.getPrice());
		pro.setQty(p.getQty());
		pro.setCategory(p.getCategory());
		return pro;
	}

	@Override
	public void destroy(int id) {
		Product7 pro = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product7","ID",id));
		repo.delete(pro);
	}

	@Override
	public Product7 retrive(int id) {
		Product7 pro = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product7","ID",id));
		return pro;
	}

}
