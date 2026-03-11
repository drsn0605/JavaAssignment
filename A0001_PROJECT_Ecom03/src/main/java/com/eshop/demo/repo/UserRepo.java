package com.eshop.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.Role;
import com.eshop.demo.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

	public List<User> findByRole(Role role);
}
