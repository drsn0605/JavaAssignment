package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Address;
import com.example.demo.model.User;

public interface AddressRepo extends JpaRepository<Address, Long>{

//	List<AddressDto> findByUser(User user);
//if we take AddressDto as return type - thn we got this error.
	
	/*
	 * "message": "No converter found capable of converting from type " +
	 * "[com.example.demo.model.Address] to type [com.example.demo.dto.AddressDto]",
	 */
	
	List<Address> findByUser(User user);
	
}
