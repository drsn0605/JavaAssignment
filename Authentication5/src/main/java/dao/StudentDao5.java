package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Student5;

public class StudentDao5 {
	
	Connection cn = null;
	
	public StudentDao5() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","drsn@1028");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int addStudent(Student5 st) {
		int i = 0;
		
		try {
			PreparedStatement ps = cn.prepareStatement("insert into user5 values(?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, st.getName());
			ps.setString(3, st.getSurname());
			ps.setString(4, st.getEmail());
			ps.setString(5, st.getPass());
			ps.setString(6, st.getLang());
			ps.setString(7, st.getOption());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
}
