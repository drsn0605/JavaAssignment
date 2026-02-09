package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Student3;

public class Student3dao {
	
	SessionFactory sf = null;
	public Student3dao() {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student3.class);
		sf = cfg.buildSessionFactory();
		
	}
	
	public int addStudent(Student3 st) {
		int i = 0;  //initialization
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.persist(st);
		tx.commit();
		i = 1;
		
		return i;	
	} 
	
	public ArrayList<Student3> viewStudent() {
		
		ArrayList<Student3> al = null;
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		al = (ArrayList<Student3>) s.createQuery("from Student3").list();    //here student3 != Student3. (class name must be exact)
		
		return al;
		
		
	}

	public int deleteStudent(int id) {
		int i = 0;
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Student3 st = s.find(Student3.class, id);
		s.remove(st);
		tx.commit();
		i = 1;
		
		return i;
		
	}

	public Student3 getElementById(int id) {
		
		Student3 st = new Student3();
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		st = s.find(Student3.class, id);
		
		
		return st;
		
		
	}

	public int updateStudent(Student3 st) {
		int i = 0;
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.merge(st);
		tx.commit();
		i = 1;
		
		return i;
		
	}

}
