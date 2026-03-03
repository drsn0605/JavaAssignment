package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category4;
import com.example.demo.model.Product4;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo prepo;
	
	@Override
	public Product4 create(Product4 p) {
		return prepo.save(p);
	}

	@Override
	public List<Product4> list() {
		return prepo.findAll();
	}

	@Override
	public Product4 update(Product4 p, int id) {
		Product4 pro = prepo.findById(id).orElseThrow();
		pro.setName(p.getName());
		pro.setPrice(p.getPrice());
		pro.setQty(p.getQty());
		pro.setCategory(p.getCategory());
		return pro;
	}

	@Override
	public void destroy(int id) {
		Product4 p = prepo.findById(id).orElseThrow();
		prepo.delete(p);
	}

	@Override
	public Product4 retrive(int id) {
		Product4 pro = prepo.findById(id).orElseThrow();
		return pro;
	}

	@Override
	public List<Product4> getByCategory(Category4 c) {
		return prepo.getByCategory(c);
	}

}
