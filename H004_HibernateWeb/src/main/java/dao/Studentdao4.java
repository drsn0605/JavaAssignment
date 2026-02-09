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

import model.Student4;

public class Studentdao4 {
	SessionFactory sf = null;
	public Studentdao4() {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student4.class);
		sf = cfg.buildSessionFactory();
	}
	public int addStudent4(Student4 st) {     //here first we are declaring return variable as void but, we have to checked i - so that we have to return i and for that we change return type as int.
		int i = 0;
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.persist(st);
		tx.commit();
		i = 1;
		return i;
		
	}
	public ArrayList<Student4> viewStudent() {
		
		ArrayList<Student4> al = new ArrayList<Student4>();
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		al = (ArrayList<Student4>) s.createQuery("from Student4").list();
		
		return al;
	}
	
	public int deleteStudent(int id) {
		int i = 0;
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Student4 st = s.find(Student4.class, id);
		s.remove(st);
		tx.commit();
		i = 1;
		
		return i;
	}
	public Student4 getElementById(int id) {
		
		Student4 st = new Student4();
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		st = s.find(Student4.class, id);
		
		return st;
		
	}
	public int updateStudent(Student4 st) {
		int i = 0;
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.merge(st);
		tx.commit();
		i = 1;
		
		return i;
	}

}
