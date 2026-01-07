package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student9;

public class StudentDao9 {
	
	Connection cn = null;
	
	public StudentDao9() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","drsn@1028");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int addStudent(Student9 st) {
		
		int i=0;
		
		try {
			PreparedStatement ps = cn.prepareStatement("insert into student09 values(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, st.getName());
			ps.setString(3, st.getEmail());
			ps.setString(4, st.getVillage());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
		
	}

	public ArrayList<Student9> viewStudent() {
		
		ArrayList<Student9> al = new ArrayList<Student9>();
		
		try {
			PreparedStatement ps = cn.prepareStatement("select * from student09");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student9 st = new Student9();
				st.setId(1);
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setVillage(rs.getString(4));
				al.add(st);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
		
		
	}
}
