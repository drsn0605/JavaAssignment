package com.eshop.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.eshop.demo.model.OrderStatus;
import com.eshop.demo.model.PaymentType;

public class OrderDto {

	private Long id;
	private UserDto user;
	private AddressDto address;
	private PaymentType paymentType;
	private String paymentId;
	private BigDecimal totalAmount;
	private OrderStatus orderstatus = OrderStatus.PENDING;
	private LocalDateTime createdAt = LocalDateTime.now();
	private List<OrderItemDtoViews> items;
	
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
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public OrderStatus getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(OrderStatus orderstatus) {
		this.orderstatus = orderstatus;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public List<OrderItemDtoViews> getItems() {
		return items;
	}
	public void setItems(List<OrderItemDtoViews> items) {
		this.items = items;
	}
	
	
}
