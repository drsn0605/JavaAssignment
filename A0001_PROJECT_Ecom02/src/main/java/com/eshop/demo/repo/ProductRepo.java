package com.eshop.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
