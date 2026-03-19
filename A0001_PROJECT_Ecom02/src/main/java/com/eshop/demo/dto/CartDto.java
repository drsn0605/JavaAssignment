package com.eshop.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CartDto {

	private Long id;
	private UserDto user;
	private List<CartItemDtoViews> items;
	private LocalDateTime createdAt = LocalDateTime.now();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
//	public List<CartItemDto> getItems() {
//		return items;
//	}
//	public void setItems(List<CartItemDto> items) {
//		this.items = items;
//	}
	public List<CartItemDtoViews> getItems() {
		return items;
	}
	public void setItems(List<CartItemDtoViews> items) {
		this.items = items;
	}
	
}
