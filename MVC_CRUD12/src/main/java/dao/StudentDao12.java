package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student12;

public class StudentDao12 {
	
	Connection cn = null;
	
	public StudentDao12() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","drsn@1028");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int addStudent(Student12 st) {
		int i = 0;
		 
		try {
			PreparedStatement ps = cn.prepareStatement("insert into stdinfo12 values(?,?,?,?,?)");
			ps.setInt(1, st.getId());
			ps.setString(2, st.getEmail());
			ps.setString(3, st.getEmail());
			ps.setString(4, st.getCity());
			ps.setString(5, st.getCountry());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public  ArrayList<Student12> viewStudent() {
		
		ArrayList<Student12> al = new ArrayList<Student12>();
		
		try {
			PreparedStatement ps = cn.prepareStatement("select * from stdinfo12");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student12 st = new Student12();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setCity(rs.getString(4));
				st.setCountry(rs.getString(5));
				al.add(st);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

	public int deleteStudent(int id) {
		int i = 0;
		
		try {
			PreparedStatement ps = cn.prepareStatement("delete from stdinfo12 where id=?");
			ps.setInt(1, id);
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	
}
