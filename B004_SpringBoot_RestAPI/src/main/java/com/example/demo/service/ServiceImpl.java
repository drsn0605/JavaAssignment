package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student4;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.StudentRepo;

@Service
public class ServiceImpl implements StudentService{

	@Autowired
	StudentRepo repo;
	
	@Override
	public Student4 create(Student4 st) {
		return repo.save(st);
	}

	@Override
	public List<Student4> read() {
		List<Student4> students = repo.findAll();
		return students;
	}

	@Override
	public Student4 update(Student4 st, int id) {
		Student4 std = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student4","ID",id));
		std.setName(st.getName());
		std.setScore(st.getScore());
		return repo.save(std);
	}

	@Override
	public void destroy(int id) {
		Student4 st = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student4","ID",id));
		repo.delete(st);
	}

	@Override
	public Student4 retrive(int id) {
		Student4 st = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student4","ID",id));
		return st;
	}

}
