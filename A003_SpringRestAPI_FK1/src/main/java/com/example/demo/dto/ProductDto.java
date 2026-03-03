package com.example.demo.dto;

public class ProductDto {
	int id;
	String name;
	double price;
	int qty;
	CategoryDto category;   //there is only id and name -> inside this CategoryDto-category. 
	//here category name must be same as - Product1(parameter - Category1 category). Bcoz ModelMapper automatic mapping karta hai.  
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	
	
}
