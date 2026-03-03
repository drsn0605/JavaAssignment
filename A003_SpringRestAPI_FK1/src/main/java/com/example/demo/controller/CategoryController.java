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
import com.example.demo.model.Category1;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService catservice;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> create(@RequestBody Category1 c) {
		
		Category1 created = catservice.create(c);
//		CategoryDto dto = new CategoryDto();
//		dto.setId(created.getId());
//		dto.setName(created.getName());
		return new ResponseEntity<>(CategoryToDto(created), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> view() {
		List<Category1> catlist = catservice.view();
		List<CategoryDto> dtos = new ArrayList<>();
		for(Category1 c : catlist) {
			dtos.add(CategoryToDto(c));
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	public static CategoryDto CategoryToDto(Category1 c) {
		CategoryDto cat = new CategoryDto();
		cat.setId(c.getId());
		cat.setName(c.getName());
		return cat;
	}
	
	public static Category1 DtoToCategroy(CategoryDto dto) {
		Category1 c = new Category1();
		c.setId(dto.getId());
		c.setName(dto.getName());
		return c;
	}
}
