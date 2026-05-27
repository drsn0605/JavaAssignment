package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Role;
import com.example.demo.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

	List<User> findByRole(Role role);
}
