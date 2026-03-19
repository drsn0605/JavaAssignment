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
	UserService userService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	ProductService proService;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	CartItemService cartItemService;
	
	@PostMapping("/")
	public ResponseEntity<CartItemDto> create(@RequestBody CartItemDto dto, @RequestParam("product") Long pid) {
		UserDto user = userService.retrive(2l);
		ProductDto pro = proService.retrive(pid);
		dto.setProduct(pro);
		
//		dto.setCart(null);  -> we want to set cart. So, first we have to find the cart of user.
		CartDto isExist = cartService.cartByUser(mapper.map(user, User.class));
		if(isExist == null) {
			//if user does not have cart, thn we have to create a new cart using new keyword.
			CartDto cart = new CartDto();
			cart.setUser(user);  //here we have attached the user to cart.
			//now we have to save this cart. So, -
//			cartService.create(cart);
			isExist = cartService.create(cart);
		}
		dto.setCart(isExist);
		
		//now we have to save product into this cart. So, 
		//we have to work with CartItem/CartItemService & CartItemServiceImpl.   
		//Bcoz,we want to add product and product is inside the CartItem not in Cart. 
		CartItemDto created = cartItemService.create(dto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<CartDto> retrive() {
		UserDto user = userService.retrive(2l);
		CartDto cartitems = cartService.cartByUser(mapper.map(user, User.class));
		return new ResponseEntity<>(cartitems, HttpStatus.OK);
	}
}
