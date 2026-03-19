package com.eshop.demo.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.demo.dto.CartItemDto;
import com.eshop.demo.model.CartItem;
import com.eshop.demo.payload.ResourceNotFoundException;
import com.eshop.demo.repo.CartItemRepo;
import com.eshop.demo.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{

	@Autowired
	CartItemRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public CartItemDto create(CartItemDto dto) {
		CartItem created = mapper.map(dto, CartItem.class);
		return mapper.map(repo.save(created), CartItemDto.class);
	}

	@Override
	public void delete(Long id) {
	 	CartItem ci = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("CartItem", "ID", id));
		repo.delete(ci);
	}

}
