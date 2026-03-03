package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product3;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo prorepo;
	
	@Override
	public Product3 create(Product3 p) {
		return prorepo.save(p);
	}

	@Override
	public List<Product3> view() {
		return prorepo.findAll();
	}

	@Override
	public Product3 update(Product3 pro, int id) {
		Product3 p = prorepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category3","ID",id));
		p.setName(pro.getName());
		p.setPrice(pro.getPrice());
		p.setQty(pro.getQty());
		p.setCategory(pro.getCategory());
		return p;
	}

	@Override
	public void destroy(int id) {
		Product3 p = prorepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category3","ID",id));
		prorepo.delete(p);
	}

	@Override
	public Product3 retrive(int cid) {
		Product3 p = prorepo.findById(cid).orElseThrow(()-> new ResourceNotFoundException("Category3","ID",cid));
		return p;
	}

}
