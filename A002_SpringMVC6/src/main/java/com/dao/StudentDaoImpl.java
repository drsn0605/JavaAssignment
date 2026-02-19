package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Student6;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public void addOrUpdate(Student6 student) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(student);
		tx.commit();
	}

	@Override
	public List<Student6> allStudent() {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		return s.createQuery("from Student6",Student6.class).list();    //here "from Student6" - Student6 must be same as Entity class(Student6.java), Student6 != student6. 
	}

	@Override
	public Student6 studentById(int id) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		return s.get(Student6.class, id);
	}

	@Override
	public void deleteStudent(int id) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Student6 st = s.get(Student6.class, id);
		s.delete(st);
		tx.commit();
	}

}
