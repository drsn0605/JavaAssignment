package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepo studentrepo;
	
	@Override
	public Student create(Student student) {
		return studentrepo.save(student);
	}

	@Override
	public List<Student> view() {
		return studentrepo.findAll();
	}

	@Override
	public Student retrive(int id) {
		return studentrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student","ID",id));
	}

	@Override
	public void destroy(int id) {
		Student st = studentrepo.findById(id).orElseThrow();
		studentrepo.delete(st);
	}

	@Override
	public Student update(Student st, int id) {
		Student std = studentrepo.findById(id).orElseThrow();
		std.setName(st.getName());
		std.setCountry(st.getCountry());
		return studentrepo.save(std);
	}

}
