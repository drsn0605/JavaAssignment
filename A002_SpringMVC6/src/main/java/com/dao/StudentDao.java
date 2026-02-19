package com.dao;

import java.util.List;

import com.model.Student6;

public interface StudentDao {
	public void addOrUpdate(Student6 student);
	public List<Student6> allStudent();
	public Student6 studentById(int id);
	public void deleteStudent(int id);
}
