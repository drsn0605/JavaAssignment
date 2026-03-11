package com.eshop.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
