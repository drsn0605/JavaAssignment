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
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService cservice;
	
	@PostMapping("/")
	public ResponseEntity<Category3> create(@RequestBody Category3 cat) {
		
		Category3 c = cservice.create(cat);
		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<Category3>> list() {
		List<Category3> clist = cservice.view();
		return new ResponseEntity<>(clist, HttpStatus.OK);
	}
}
