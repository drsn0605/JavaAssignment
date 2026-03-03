package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="product5")
public class Product5 {
	
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
	Category5 category;

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

	public Category5 getCategory() {
		return category;
	}

	public void setCategory(Category5 category) {
		this.category = category;
	}
}
