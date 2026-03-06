package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem, Long>{

	List<CartItem> findByCartId(Long cartId);
}
