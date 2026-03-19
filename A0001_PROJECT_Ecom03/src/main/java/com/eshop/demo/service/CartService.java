package com.eshop.demo.service;

import com.eshop.demo.dto.CartDto;
import com.eshop.demo.model.User;

public interface CartService {

	public CartDto create(CartDto dto);
	public CartDto CartByUser(User user);
	public void destroy(Long id);
	
}
