package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category8;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService cservice;
	
	@PostMapping("/")
	public ResponseEntity<Category8> create(@RequestBody Category8 c) {
		Category8 cat = cservice.create(c);
		return new ResponseEntity<>(cat,HttpStatus.CREATED);
	}
}
