package com.eshop.demo.dto;

import java.time.LocalDateTime;

public class CartItemDtoViews {

	private Long id;
//	private CartDto cart;   - we have to remove this cart. Bcoz of this we got infinite loop. So,... 
	// now in CartDto we just have to change CartItemDto -> CartItemDtoViews. 
	private ProductDto product;	
	private Integer qty;
	private LocalDateTime createdAt = LocalDateTime.now();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public ProductDto getProduct() {
		return product;
	}
	public void setProduct(ProductDto product) {
		this.product = product;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}
