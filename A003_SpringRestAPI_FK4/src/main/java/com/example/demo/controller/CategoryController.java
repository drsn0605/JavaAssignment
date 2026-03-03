package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDto;
import com.example.demo.model.Category4;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService cservice;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> create(@RequestBody Category4 c) {
		Category4 cat = cservice.create(c);
		return new ResponseEntity<>(CategoryToDto(cat), HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<Category4>> list() {
		List<Category4> clist = cservice.list();
		return new ResponseEntity<>(clist, HttpStatus.OK);
	}
	
	public static CategoryDto CategoryToDto(Category4 cat) {
		CategoryDto dto = new CategoryDto();
		dto.setId(cat.getId());
		dto.setName(cat.getName());
		return dto;
	}
}
