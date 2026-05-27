package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.model.Category;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public CategoryDto create(CategoryDto dto) {
		Category c = mapper.map(dto, Category.class);
		Category created = repo.save(c);
		return mapper.map(created, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> list() {
		List<Category> clist = repo.findAll();
		List<CategoryDto> dtos = clist.stream().map(c->{
			return mapper.map(c, CategoryDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public CategoryDto update(CategoryDto dto, Long id) {
		Category c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "ID", id));
		c.setName(dto.getName());
		c.setDescription(dto.getDescription());
		return mapper.map(repo.save(c), CategoryDto.class);
	}

	@Override
	public CategoryDto retrive(Long id) {
		Category c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "ID", id));
		return mapper.map(c,CategoryDto.class);
	}

	@Override
	public void delete(Long id) {
		Category c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "ID", id));
		repo.delete(c);
	}

}
