package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="product8")
public class Product8 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	@Column(name="pname")
	String name;
	@Column(name="price")
	double price;
	@Column(name="qty")
	int qty;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="cid")
	Category8 category;

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

	public Category8 getCategory() {
		return category;
	}

	public void setCategory(Category8 category) {
		this.category = category;
	}
	
}
