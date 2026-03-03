package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student2;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.StudentRepo;

@Service
public class ServiceImpl implements StudentService{

	@Autowired
	StudentRepo repo;
	
	@Override
	public Student2 create(Student2 student) {
		return repo.save(student);
	}

	@Override
	public List<Student2> read() {
		return repo.findAll();
	}

	@Override
	public Student2 update(Student2 st, int id) {
		Student2 std = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student2","ID",id));
		std.setName(st.getName());
		std.setGrade(st.getGrade());
		return repo.save(std);
	}

	@Override
	public void destroy(int id) {
//		repo.deleteById(id);   //not recommended
		Student2 st = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student2","ID",id));    //recommended
		repo.delete(st);
	}
	

	@Override
	public Student2 retrive(int id) {
		Student2 st = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student2","ID",id));
		return st;
	}

}
