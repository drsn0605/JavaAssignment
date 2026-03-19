package com.eshop.demo.controller;

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

import com.eshop.demo.dto.AddressDto;
import com.eshop.demo.dto.CartDto;
import com.eshop.demo.dto.CartItemDtoViews;
import com.eshop.demo.dto.OrderDto;
import com.eshop.demo.dto.OrderItemDto;
import com.eshop.demo.dto.UserDto;
import com.eshop.demo.model.User;
import com.eshop.demo.service.AddressService;
import com.eshop.demo.service.CartItemService;
import com.eshop.demo.service.CartService;
import com.eshop.demo.service.OrderService;
import com.eshop.demo.service.UserService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	AddressService addservice;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	OrderService oservice;
	
	@Autowired
	CartService cartservice;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	CartItemService cartitemservice;
	
	@PostMapping("/")
	public void create(@RequestBody OrderDto dto, @RequestParam("address") Long aid) {
		AddressDto adr = addservice.retrive(aid);
		UserDto user = userservice.retrive(2l);
		dto.setAddress(adr);
		dto.setUser(user);
		
		OrderDto createdOrder = oservice.create(dto);
		//now we have to order from Cart - So, we have to get Cart of user. 
		CartDto cart = cartservice.cartByUser(mapper.map(user, User.class));
		
		OrderItemDto odto = new OrderItemDto();
		for(CartItemDtoViews cartItem : cart.getItems()) {
			odto.setOrder(createdOrder);
			odto.setProduct(cartItem.getProduct());
			odto.setQty(cartItem.getQty());
			odto.setPrice(cartItem.getProduct().getPrice());
			
			oservice.create(odto);
			
			//we have to delete products from cartitem. So, 
			cartitemservice.delete(cartItem.getId());
		}
		
		//we also have to delete cart. So, 
		cartservice.delete(cart.getId());
	}
	
	//we want orders by user. So, 
	@GetMapping("/")
	public ResponseEntity<List<OrderDto>> list() {
		UserDto user = userservice.retrive(1l);
		List<OrderDto> dtos = oservice.list(user);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<OrderDto>> listAll() {
		List<OrderDto> dtos = oservice.list();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
}
