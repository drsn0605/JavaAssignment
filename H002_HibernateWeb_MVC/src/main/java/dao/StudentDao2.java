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

import model.Student2;

public class StudentDao2 {
	
	SessionFactory sf = null;
	
	public StudentDao2() {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");  //connection with DB
		cfg.addAnnotatedClass(Student2.class);  //connection with Table
		sf = cfg.buildSessionFactory();
	}
	
	public int addStudent(Student2 st) {
		int i = 0;
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.persist(st);
		tx.commit();
		i = 1;
		
		return i;
	
	}
	
	public ArrayList<Student2> viewStudent() {
		
		ArrayList<Student2> al = null;
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		al = (ArrayList<Student2>) s.createQuery("from Student2").list();
		
		return al;
	}

	public int deleteStudent(int id) {
		int i = 0;
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Student2 st = s.find(Student2.class, id);
		s.remove(st);
		tx.commit();
		i = 1;
		
		return i;
	}

	public Student2 getElementById(int id) {
		
		Student2 st = new Student2();  
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		st = s.find(Student2.class, id);
		
		return st;
		
	}

	public int updateStudent(Student2 st) {
		
		int i = 0;
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.merge(st);
		tx.commit();
		i = 1;
		
		return i;
	
	}
	
}
