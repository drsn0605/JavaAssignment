package com.eshop.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.demo.dto.CategoryDto;
import com.eshop.demo.model.Category;
import com.eshop.demo.payload.ResourceNotFoundException;
import com.eshop.demo.repo.CategoryRepo;
import com.eshop.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public CategoryDto create(CategoryDto dto) {
		Category c = mapper.map(dto, Category.class);
		return mapper.map(repo.save(c), CategoryDto.class);
	}

	@Override
	public List<CategoryDto> list() {
		List<Category> plist = repo.findAll();
		List<CategoryDto> dtos = plist.stream().map(p->{
			return mapper.map(p, CategoryDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public CategoryDto update(CategoryDto dto, Long id) {
		Category c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "ID", id));
		c.setName(dto.getName());
		c.setDescription(dto.getDescription());
		c.setCreatedAt(dto.getCreatedAt());
		return mapper.map(repo.save(c), CategoryDto.class);
	}

	@Override
	public void destroy(Long id) {
		Category c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "ID", id));
		repo.delete(c);
	}

	@Override
	public CategoryDto retrive(Long id) {
		Category c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "ID", id));
		return mapper.map(c, CategoryDto.class);
	}

}
