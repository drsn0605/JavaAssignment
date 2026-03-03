package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category8;
import com.example.demo.model.Product8;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService pservice;
	
	@Autowired
	CategoryService cservice;
	
	@PostMapping("/category/{id}")
	public ResponseEntity<Product8> create(@RequestBody Product8 p,@PathVariable("id") int id) {
		Category8 c = cservice.retrive(id);
		p.setCategory(c);
		Product8 pro = pservice.create(p);
		return new ResponseEntity<>(pro, HttpStatus.CREATED);
	}
	
	public ResponseEntity<List<Product8>> list() {
		List<Product8> plist = pservice.list();
		return new ResponseEntity<>(plist, HttpStatus.OK);
	}
}
