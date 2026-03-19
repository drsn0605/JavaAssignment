package com.example.demo.service;

import com.example.demo.dto.CartDto;
import com.example.demo.model.User;

public interface CartService {

	public CartDto cartByUser(User user);
	public CartDto create(CartDto dto);
	public void destroy(Long id);
}
