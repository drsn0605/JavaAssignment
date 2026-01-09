package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDao {
	
	Connection cn = null;
	public UserDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","drsn@1028");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
