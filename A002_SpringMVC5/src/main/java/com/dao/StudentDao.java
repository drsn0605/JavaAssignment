package com.dao;

import java.util.List;

import com.model.Student5;

public interface StudentDao {
	public void addOrUpdate(Student5 student);
	public List<Student5> viewStudent();
	public Student5 getById(int id);
	public void deleteStudent(int id);
	
}
