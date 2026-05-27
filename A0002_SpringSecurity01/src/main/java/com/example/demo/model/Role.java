package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String role;
	
	@ManyToMany
	@JoinTable(
			name="user_role",
			joinColumns = @JoinColumn(name="rid"),
			inverseJoinColumns = @JoinColumn(name="uid")
			)
	List<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
