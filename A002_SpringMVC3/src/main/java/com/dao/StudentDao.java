package com.dao;

import java.util.List;

import com.model.Student3;

public interface StudentDao {
	public void addOrUpdate(Student3 student);
	public List<Student3> viewStudent();
	public void deleteStudent(int id);
	public Student3 studentById(int id);
	
}
