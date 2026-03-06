package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{

	List<Address> findByUserId(Long userId);
}
