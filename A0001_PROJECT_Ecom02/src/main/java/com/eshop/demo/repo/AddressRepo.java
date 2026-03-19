package com.eshop.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.Address;
import com.eshop.demo.model.User;

public interface AddressRepo extends JpaRepository<Address, Long> {

	List<Address> findByUser(User user);
}
