package com.eshop.demo.controller;

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

import com.eshop.demo.dto.CartDto;
import com.eshop.demo.dto.CartItemDto;
import com.eshop.demo.dto.ProductDto;
import com.eshop.demo.dto.UserDto;
import com.eshop.demo.model.User;
import com.eshop.demo.service.CartItemService;
import com.eshop.demo.service.CartService;
import com.eshop.demo.service.ProductService;
import com.eshop.demo.service.UserService;

@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	CartService service;
	
	@Autowired
	UserService uservice;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	ProductService pservice;
	
	@Autowired
	CartItemService cartItemService;
	
	@PostMapping("/")
	public ResponseEntity<CartItemDto> create(@RequestBody CartItemDto dto, @RequestParam("product") Long pid) {
		UserDto udto = uservice.retrive(2l);
		ProductDto pro = pservice.retrive(pid);
		dto.setProduct(pro);
		User u = mapper.map(udto, User.class);
		CartDto isExist = service.CartByUser(u);
		if(isExist == null) {
			CartDto cart = new CartDto();
//			dto.setCart(cart);   -> this is wrong. I have to attach user to this cart. So, -
			cart.setUser(mapper.map(u, UserDto.class));
			isExist = service.create(cart);  //saving the cart
		}
		dto.setCart(isExist);   //attach cart to CartItem.
		
		CartItemDto created = cartItemService.create(dto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<CartDto> retrive() {
		UserDto user = uservice.retrive(2l);
		CartDto cart = service.CartByUser(mapper.map(user, User.class));
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}
}
