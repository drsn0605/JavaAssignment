package com.eshop.demo.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.demo.dto.CartDto;
import com.eshop.demo.model.Cart;
import com.eshop.demo.model.User;
import com.eshop.demo.payload.ResourceNotFoundException;
import com.eshop.demo.repo.CartRepo;
import com.eshop.demo.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public CartDto create(CartDto dto) {
		Cart c = mapper.map(dto, Cart.class);
		return mapper.map(repo.save(c), CartDto.class);
	}

	@Override
	public CartDto cartByUser(User user) {
		CartDto dt = null;
		Cart c = repo.findByUser(user);
		if(c != null) {
			dt = mapper.map(c, CartDto.class);
		}
		return dt;
	}

	@Override
	public void delete(Long id) {
		Cart cart = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cart", "ID", id));
		repo.delete(cart);
	}

}
