package com.eshop.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem, Long> {

}
