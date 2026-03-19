package com.eshop.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long>{

}
