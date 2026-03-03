package com.example.demo.controller;

import java.util.ArrayList;
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
import com.example.demo.model.Category7;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	@PostMapping("/")
	public ResponseEntity<Category7> create(@RequestBody Category7 c) {
		Category7 cat = service.create(c);
		return new ResponseEntity<>(cat, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<CategoryDto>> list() {
		List<Category7> clist = service.list();
		List<CategoryDto> dtos = new ArrayList<>();
		for(Category7 c : clist) {
			dtos.add(CategoryToDto(c));
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	public CategoryDto CategoryToDto(Category7 c) {
		CategoryDto dto = new CategoryDto();
		dto.setId(c.getId());
		dto.setName(c.getName());
		return dto;
	}
}
