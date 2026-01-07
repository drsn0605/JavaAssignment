package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student10;

public class StudentDao10 {
	
	Connection cn = null; 
			
	public StudentDao10() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","drsn@1028");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int addStudent(Student10 st) {
		int i = 0;
		
		try {
			PreparedStatement ps = cn.prepareStatement("insert into stdinfo10 values(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, st.getName());
			ps.setString(3, st.getEmail());
			ps.setString(4, st.getCity());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public ArrayList<Student10> viewStudent() {
		
		ArrayList<Student10> al = new ArrayList<Student10>();
		
		try {
			PreparedStatement ps = cn.prepareStatement("select * from stdinfo10");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student10 st = new Student10();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setCity(rs.getString(4));
				al.add(st);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
		
		
	}

}
