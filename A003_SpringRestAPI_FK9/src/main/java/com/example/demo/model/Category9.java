package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="category9")
public class Category9 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	@Column(name="cname")
	String name;
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
	
}
