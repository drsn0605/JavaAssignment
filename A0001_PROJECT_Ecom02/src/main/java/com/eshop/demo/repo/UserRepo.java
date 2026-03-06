package com.eshop.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
