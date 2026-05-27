package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CartDto;
import com.example.demo.dto.CartItemDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.CartItemService;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	UserService userservice;
	
	@Autowired
	ProductService proservice;
	
	@Autowired
	CartService cartservice;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	CartItemService cartitemservice;
	
	@PostMapping("/")
	public ResponseEntity<CartItemDto> create(@RequestBody CartItemDto dto, @RequestParam("product") Long id) {
		UserDto user = userservice.retrive(4l);
		ProductDto pro = proservice.retrive(id);
		dto.setProduct(pro);
		
		CartDto isExist = cartservice.cartByUser(mapper.map(user, User.class));
		if(isExist == null) {
			CartDto cart = new CartDto();
			cart.setUser(user);
			//now we have to save this cart. So, 
			isExist = cartservice.create(cart);
		}
		dto.setCart(isExist);
		
		CartItemDto created = cartitemservice.create(dto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<CartDto> view() {
		UserDto user = userservice.retrive(2l);
		CartDto cart = cartservice.cartByUser(mapper.map(user, User.class));
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}
}
