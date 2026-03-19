package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Cart;
import com.example.demo.model.User;

public interface CartRepo extends JpaRepository<Cart, Long> {

	Cart findByUser(User user);
}
