package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	CategoryService catservice;
	
	@Override
	public ProductDto create(ProductDto dto) {
		Product pro = repo.save(mapper.map(dto, Product.class));
		return mapper.map(pro, ProductDto.class);
	}

	@Override
	public List<ProductDto> list() {
		List<Product> plist = repo.findAll();
		List<ProductDto> dtos = plist.stream().map(p->{
			return mapper.map(p, ProductDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public ProductDto update(ProductDto dto, Long id) {
		Product pro = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product", "ID", id));
		pro.setName(dto.getName());
		pro.setDescription(dto.getDescription());
		pro.setPrice(dto.getPrice());
		pro.setQty(dto.getQty());
		pro.setImage(dto.getImage());
		pro.setActive(dto.isActive());
		pro.setCreatedAt(dto.getCreatedAt());
		pro.setCategory(mapper.map(dto.getCategory(), Category.class));
		return mapper.map(repo.save(pro), ProductDto.class);
	}

	@Override
	public void destroy(Long id) {
		Product pro = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product", "ID", id));
		repo.delete(pro);
	}

	@Override
	public ProductDto retrive(Long id) {
		Product pro = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product", "ID", id));
		return mapper.map(pro, ProductDto.class);
	}

	@Override
	public List<ProductDto> findByCategory(Long cid) {
		CategoryDto cat = catservice.retrive(cid);
		List<Product> plist = repo.findByCategory(mapper.map(cat, Category.class));
		List<ProductDto> dtos = plist.stream().map(p->{
			return mapper.map(p, ProductDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

}
