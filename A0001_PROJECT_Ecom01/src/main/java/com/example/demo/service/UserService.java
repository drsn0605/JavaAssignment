package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	public User create(User u);
	public List<User> list();
	public User update(User u, int id);
	public void destroy(int id);
	public User retrive(int rid);
}
