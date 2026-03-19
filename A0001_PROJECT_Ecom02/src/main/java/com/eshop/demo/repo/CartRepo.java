package com.eshop.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.Cart;
import com.eshop.demo.model.User;

public interface CartRepo extends JpaRepository<Cart, Long>{

	Cart findByUser(User user);
}
