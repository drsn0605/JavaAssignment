package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product11;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	
	@Override
	public Product11 create(Product11 pro) {
		// TODO Auto-generated method stub
		return repo.save(pro);
	}

	@Override
	public List<Product11> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product11 update(Product11 p, int id) {
		Product11 pro = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product11","ID",id));
		pro.setName(p.getName());
		pro.setPrice(p.getPrice());
		pro.setQty(p.getQty());
		pro.setCategory(p.getCategory());
		return repo.save(pro);
	}

	@Override
	public void destroy(int id) {
		Product11 pro = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product11","ID",id));
		repo.delete(pro);
	}

	@Override
	public Product11 retrive(int id) {
		Product11 pro = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product11","ID",id));
		return pro;
	}

}
