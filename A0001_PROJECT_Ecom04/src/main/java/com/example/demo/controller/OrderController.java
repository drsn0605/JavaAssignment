package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.CartDto;
import com.example.demo.dto.CartItemDtoViews;
import com.example.demo.dto.OrderDto;
import com.example.demo.dto.OrderItemDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.AddressService;
import com.example.demo.service.CartItemService;
import com.example.demo.service.CartService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderservice;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	AddressService addservice;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	CartService cartservice;
	
	@Autowired
	CartItemService cartitemservice;
	
	@PostMapping("/")
	public void create(@RequestBody OrderDto dto, @RequestParam("address") Long aid) {
		UserDto user = userservice.retrive(2l);
		AddressDto adr = addservice.retrive(aid);
		dto.setUser(user);
		dto.setAddress(adr);
		
		OrderDto created = orderservice.create(dto);
		//now we want to order from cart. So, first we have to get cart of user.
		CartDto cart = cartservice.cartByUser(mapper.map(user, User.class));
		
		OrderItemDto odto = new OrderItemDto();
		for(CartItemDtoViews cartitem : cart.getItems()) {
			odto.setOrder(created);
			odto.setProduct(cartitem.getProduct());
			odto.setQty(cartitem.getQty());
			odto.setPrice(cartitem.getProduct().getPrice());
			
			orderservice.create(odto);
			
			cartitemservice.destroy(cartitem.getId());
		}
		
		cartservice.destroy(cart.getId());
	}
	
	@GetMapping("/")
	public ResponseEntity<List<OrderDto>> list() {
		UserDto user = userservice.retrive(2l);
		List<OrderDto> dtos = orderservice.list(user);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<OrderDto>> listAll() {
		List<OrderDto> dtos = orderservice.list();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
}
