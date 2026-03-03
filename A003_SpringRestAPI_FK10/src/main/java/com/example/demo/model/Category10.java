package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="category10")
public class Category10 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	@Column(name="cname")
	String name;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	List<Product10> products;

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

	public List<Product10> getProducts() {
		return products;
	}

	public void setProducts(List<Product10> products) {
		this.products = products;
	} 
}
