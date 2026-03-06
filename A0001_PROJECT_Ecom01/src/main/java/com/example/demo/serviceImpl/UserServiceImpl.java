package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public UserDto create(UserDto dto) {
		//here first we have to convert dto -> user. So, we user mapper.[why dto -> user ? Bcoz, in UserRepo - 
		//public interface UserRepo extends JpaRepository<User, Long>{   -> here UserRepo is accepting User only. Not UserDto. 
		User user = mapper.map(dto, User.class);
		User created = repo.save(user);
		//now we have to convert this user(created) -> dto.
		UserDto udto = mapper.map(created, UserDto.class);
		return udto;
	}

	@Override
	public List<UserDto> list() {
		List<User> ulist = repo.findAll();
//		List<UserDto> dtos = new ArrayList<>();
//		for(User u : ulist) {
//			dtos.add(mapper.map(u, UserDto.class));
//		}
		List<UserDto> dtos = ulist.stream().map(u -> {
			return mapper.map(u, UserDto.class);
		}).collect(Collectors.toList());
		
		return dtos;
	}

	@Override
	public UserDto update(UserDto dto, Long id) {
		User u = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","ID",id));
		u.setName(dto.getName());
		u.setEmail(dto.getEmail());
		u.setPass(dto.getPass());
		u.setRole(mapper.map(dto.getRole(),Role.class));
		return mapper.map(repo.save(u), UserDto.class);
	}

	@Override
	public UserDto retrive(Long id) {
		User user = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","ID",id));
		UserDto dto = mapper.map(user, UserDto.class);
		return dto;
	}

	@Override
	public void destroy(Long id) {
		User user = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","ID",id));
		repo.delete(user);
	}
	
	
	
}
