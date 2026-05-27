package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.CategoryDto;
import com.example.demo.model.Category;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.service.CategoryService;

@RestControllerAdvice
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public CategoryDto create(CategoryDto dto) {
		Category created = repo.save(mapper.map(dto, Category.class));
		return mapper.map(created,CategoryDto.class);
	}

	@Override
	public List<CategoryDto> list() {
		List<Category> clist = repo.findAll();
		List<CategoryDto> dtos = clist.stream().map(c->{
			return mapper.map(c,CategoryDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public CategoryDto update(CategoryDto dto, Long id) {
		Category cat = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","ID",id));
		cat.setName(dto.getName());
		cat.setDescription(dto.getDescription());
		cat.setCreatedAt(dto.getCreatedAt());
		return mapper.map(repo.save(cat), CategoryDto.class);
	}

	@Override
	public void destroy(Long id) {
		Category cat = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","ID",id));
		repo.delete(cat);
	}

	@Override
	public CategoryDto retrive(Long id) {
		Category cat = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","ID",id));
		return mapper.map(cat,CategoryDto.class);
	}

}
