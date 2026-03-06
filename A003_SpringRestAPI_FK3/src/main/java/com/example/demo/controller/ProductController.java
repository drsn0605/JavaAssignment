package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category3;
import com.example.demo.model.Product3;
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
	public ResponseEntity<Product3> create(@RequestBody Product3 pro, @PathVariable int id) {
		Category3 c = cservice.retrive(id);
		pro.setCategory(c);
		Product3 p = pservice.create(pro);
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<Product3>> list() {
		List<Product3> plist = pservice.view();
		return new ResponseEntity<>(plist, HttpStatus.OK);
	}
}
