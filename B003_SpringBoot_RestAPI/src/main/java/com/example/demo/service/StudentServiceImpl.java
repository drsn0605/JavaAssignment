package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student3;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepo repo;
	
	@Override
	public Student3 create(Student3 student) {
		return repo.save(student);
	}

	@Override
	public List<Student3> read() {
		return repo.findAll();
	}

	@Override
	public Student3 update(Student3 st, int id) {
		Student3 std = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student3","ID",id));
		std.setName(st.getName());
		std.setEmail(st.getEmail());
		return repo.save(std);
	}

	@Override
	public void destroy(int id) {
		Student3 st = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student3","ID",id));
		repo.delete(st);
	}

	@Override
	public Student3 retrive(int id) {
//		return repo.findById(id).orElseThrow();  //this is for simple CRUD project.
		Student3 st = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student3","ID",id));   //recommended
		return st;
	}

}
