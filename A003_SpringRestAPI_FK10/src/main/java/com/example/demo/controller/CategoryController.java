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
import com.example.demo.model.Category10;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService cservice;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> create(@RequestBody Category10 c) {
		Category10 created = cservice.create(c);
		return new ResponseEntity<>(CategoryToDto(created),HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<CategoryDto>> list() {
		List<Category10> clist = cservice.list();
		List<CategoryDto> dtos = new ArrayList<>();
		for(Category10 c : clist) {
			dtos.add(CategoryToDto(c));
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	public static CategoryDto CategoryToDto(Category10 c) {
		CategoryDto dto = new CategoryDto();
		dto.setId(c.getId());
		dto.setName(c.getName());
		return dto;
	}
}
