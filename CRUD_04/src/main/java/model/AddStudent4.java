package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddStudent4 {
	public static void main(String[] args) {
		
		Student4 st = new Student4();
		st.setId(1);
		st.setName("tiger");
		st.setEmail("tiger@gmail.com");
		
//		Configuration cfg = new Configuration();    //load configuration
//		cfg.configure("hibernate.cfg.xml");   //we gwt DB Connection from here. 
//		cfg.addAnnotatedClass(Student4.class);   //we get Table Connection from here.

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");   //from here we get DB connection 
		cfg.addAnnotatedClass(Student4.class);   //from here we get Table Connection
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();  //opens a DB session(like a JDBC connection) to interect with DB.
		
		Transaction tx = s.beginTransaction();  //Starts a transaction..So, all DB operations happen safely as a one unit.
		
//		s.persist(st);   //to save the st(Student object) in DB.
		
		s.merge(st);    //to update the st(Student object) in DB.
		
		tx.commit();  //commits the transaction.(Data is permanently saved in DB)
		
		
	}

}
