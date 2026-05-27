package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Order;
import com.example.demo.model.User;

public interface OrderRepo extends JpaRepository<Order, Long>{

	List<Order> findByUser(User user);
}
