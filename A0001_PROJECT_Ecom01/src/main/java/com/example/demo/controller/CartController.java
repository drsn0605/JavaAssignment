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
@RequestMapping("/carts")
public class CartController {

	@Autowired
	CartService service;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	ProductService proservice;
	
	@Autowired
	CartItemService cartItemService;
	
//	@PostMapping("/")
//	public void create(@RequestBody CartItemDto dto, @RequestParam("user") Long id) {
//		/*
//		 * We pass CartItemDto in @RequestBody because the API's purpose is to add a
//		 * product to a cart. So the request must contain: product and quantity, which belong
//		 * to CartItem, not Cart.So, in @RequestBody we take CartItemDto.
//		 */
//		
//		//first we have to find user. So, 
//		UserDto user = userservice.retrive(id);
//		
//		CartDto isExist = service.cartByUser(mapper.map(user, User.class));
//		if(isExist == null) {
//			//if cart is not exist then create a new cart.
//			CartDto cart = new CartDto();
//			cart.setUser(user);  //attach user to cart. 
//			//now we have to save that cart. So, 
//			isExist = service.create(cart);  //now cart is created in DB. 
//		}
//		
//		//If cart already exist, thn attach cart to cartItem.
//		dto.setCart(isExist);  //Now cartItem knows - which cart it belongs to. 
//		System.out.println("done!!");
//	}
	
	@PostMapping("/")
	public ResponseEntity<CartItemDto> create(@RequestBody CartItemDto dto, @RequestParam("product") Long pid) {
		/*
		 * We pass CartItemDto in @RequestBody because the API's purpose is to add a
		 * product to a cart. So the request must contain: product and quantity, which belong
		 * to CartItem, not Cart.So, in @RequestBody we take CartItemDto.
		 */
		
		//first we have to find user. So, 
		UserDto user = userservice.retrive(8l);
		
		ProductDto pro = proservice.retrive(pid);
		dto.setProduct(pro);
		
		CartDto isExist = service.cartByUser(mapper.map(user, User.class));
		if(isExist == null) {
			//if cart is not exist then create a new cart.
			CartDto cart = new CartDto();
			cart.setUser(user);  //attach user to cart. 
			//now we have to save that cart. So, 
			isExist = service.create(cart);  //now cart is created in DB. 
		}
		
		//If cart already exist, thn attach cart to cartItem.
		dto.setCart(isExist);  //Now cartItem knows - which cart it belongs to. 
		
		CartItemDto created = cartItemService.create(dto);
		return new ResponseEntity<>(created , HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<CartDto> retrive() {
		UserDto user = userservice.retrive(8l);
		CartDto cart = service.cartByUser(mapper.map(user, User.class));
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}
}
