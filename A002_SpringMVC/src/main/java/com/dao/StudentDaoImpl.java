package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Student;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public void addOrUpdate(Student student) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(student);
		tx.commit();
		
	}

	@Override
	public List<Student> viewStudent() {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		return s.createQuery("from Student", Student.class).list();
	}

	@Override
	public Student studentById(int id) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		return s.get(Student.class, id);
	}

	@Override
	public void deleteStudent(int id) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Student st = s.get(Student.class, id);
		s.delete(st);
		tx.commit();
	}
	
}
