package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddStudent {
	public static void main(String[] args) {
		
		Student3 st = new Student3();
		st.setId(0);
		st.setName("rahul");
		st.setEmail("rahul@gmail.com");
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student3.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
//		s.persist(st);  //to add element
		s.merge(st);
		
		tx.commit();
	}

}
