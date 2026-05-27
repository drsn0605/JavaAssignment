package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CategoryDto;

public interface CategoryService {

	public CategoryDto create(CategoryDto dto);
	public List<CategoryDto> list();
	public CategoryDto update(CategoryDto dto, Long id);
	public CategoryDto retrive(Long id);
	public void delete(Long id);
	
}
