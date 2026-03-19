package com.eshop.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.Order;
import com.eshop.demo.model.User;

public interface OrderRepo extends JpaRepository<Order, Long>{

	List<Order> findByUser(User user);
}
