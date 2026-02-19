package com.dao;

import java.util.List;

import com.model.Student7;

public interface StudentDao {
	public void addOrUpdate(Student7 st);
	public List<Student7> viewStudent();
	public Student7 getById(int id);
	public void deleteStudent(int id);
	
}
