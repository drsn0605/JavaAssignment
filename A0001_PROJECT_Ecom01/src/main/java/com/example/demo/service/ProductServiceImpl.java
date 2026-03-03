package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
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
	public Product update(Product p, int id) {
		Product pro = repo.findById(id).orElseThrow();
		pro.setName(p.getName());
		pro.setPrice(p.getPrice());
		pro.setQty(p.getQty());
		pro.setImage(p.getImage());
		return pro;
	}

	@Override
	public void destroy(int id) {
		Product pro = repo.findById(id).orElseThrow();
		repo.delete(pro);
	}

	@Override
	public Product retrive(int cid) {
		Product pro = repo.findById(cid).orElseThrow();
		return pro;
	}

}
