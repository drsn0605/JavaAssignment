package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.AddressDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.AddressRepo;
import com.example.demo.service.AddressService;
import com.example.demo.service.UserService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	UserService userservice;
	
	@Override
	public AddressDto create(AddressDto adr) {
		Address adrs = mapper.map(adr, Address.class);
		return mapper.map(repo.save(adrs), AddressDto.class);
	}

	@Override
	public List<AddressDto> list() {
		List<Address> alist = repo.findAll();
		List<AddressDto> dtos = alist.stream().map(a->{
			return mapper.map(a, AddressDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public AddressDto update(AddressDto dto, Long id) {
		Address adr = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address", "ID", id));
		adr.setAddressLine(dto.getAddressLine());
		adr.setCity(dto.getCity());
		adr.setState(dto.getState());
		adr.setPincode(dto.getPincode());
		adr.setCountry(dto.getCountry());
		adr.setDefault(dto.isDefault());
		return mapper.map(repo.save(adr), AddressDto.class);
	}

	@Override
	public void destroy(Long id) {
		Address adr = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address", "ID", id));
		repo.delete(adr);
	}

	@Override
	public AddressDto retrive(Long id) {
		Address adr = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address", "ID", id));
		return mapper.map(adr, AddressDto.class);
	}

	@Override
	public List<AddressDto> getByUser(Long uid) {
		UserDto dto = userservice.retrive(uid);
		User u = mapper.map(dto, User.class);
		List<Address> alist = repo.findByUser(u);
//		System.out.println(alist);
		List<AddressDto> dtos = alist.stream().map(a->{
			return mapper.map(a, AddressDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

}
