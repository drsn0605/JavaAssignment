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
	UserService userservice;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	ProductService pservice;
	
	@Autowired
	CartItemService cartItemService;
	
//	@PostMapping("/")
//	public void create(@RequestBody CartItemDto dto, @RequestParam("user") Long id) {
//		UserDto u = userservice.retrive(id);  //get the user
//		CartDto isExist = service.cartByUser(mapper.map(u, User.class));  //check whether user has cart or not.
//		if(isExist == null) {   //if user does not have cart,
//			CartDto cart = new CartDto();   //create new cart
//			cart.setUser(u);   //attach user into cart 
//			isExist = service.create(cart);    //save the cart 
//		}
//		dto.setCart(isExist);    //if cart already exist, thn attach cart to cartitem.
//	}
	
	@PostMapping("/")
	public ResponseEntity<CartItemDto> create(@RequestBody CartItemDto dto, @RequestParam("product") Long pid) {
		
		//first get product 
		ProductDto product = pservice.retrive(pid);
		//now attach this product into dto
		dto.setProduct(product);
		UserDto u = userservice.retrive(2l);    //make user static 
		CartDto isExist = service.cartByUser(mapper.map(u, User.class)); 
		if(isExist == null) {  
			CartDto cart = new CartDto();   
			cart.setUser(u);  
			isExist = service.create(cart);   
		}
		dto.setCart(isExist);
		
		//now we have to save this product into Cart. So, 
		CartItemDto created = cartItemService.create(dto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<CartDto> retrive() {
		UserDto u = userservice.retrive(2l);   //first we get the user(jiska hame Cart dekhna hai wo)
		CartDto c = service.cartByUser(mapper.map(u, User.class));
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
}

