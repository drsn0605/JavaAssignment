package com.dao;

import java.util.List;

import com.model.Student4;

public interface StudentDao {
	public void addOrUpdate(Student4 student);
	public List<Student4> viewStudent();
	public void deleteStudent(int id);
	public Student4 getStudentById(int id);
}
