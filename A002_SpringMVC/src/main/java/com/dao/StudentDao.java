package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDao {
	
	public void addOrUpdate(Student student);   //whichever object we pass over here, that will stored in DB.
	public List<Student> viewStudent();
	public Student studentById(int id);
	public void deleteStudent(int id);
	
}
