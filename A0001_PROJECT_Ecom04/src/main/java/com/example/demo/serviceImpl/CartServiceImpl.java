package com.example.demo.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CartDto;
import com.example.demo.model.Cart;
import com.example.demo.model.User;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CartRepo;
import com.example.demo.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepo cartrepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public CartDto cartByUser(User user) {
		CartDto dt = null;
		Cart c = cartrepo.findByUser(user);
		if(c != null) {
			dt = mapper.map(c, CartDto.class);
		}
		return dt;
	}

	@Override
	public CartDto create(CartDto dto) {
		Cart created = mapper.map(dto, Cart.class);
//		cartrepo.save(dto);
		return mapper.map(cartrepo.save(created), CartDto.class);
	}

	@Override
	public void destroy(Long id) {
		Cart c = cartrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Cart", "ID", id));
		cartrepo.delete(c);
	}

}
