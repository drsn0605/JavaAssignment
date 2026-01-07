package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student3;

public class Student3dao {
	
	Connection cn = null;
	public Student3dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","drsn@1028");
			
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int addStudent(Student3 st) {
		int i = 0;  //initialization
		
//		PreparedStatement ps = cn.preparedStatement("insert into student3 values(?,?,?,?)");
		try {
			PreparedStatement ps = cn.prepareStatement("insert into student3 values(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, st.getName());
			ps.setString(3, st.getEmail());
			ps.setString(4, st.getNum());
			
			 i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;	
	} 
	
	public ArrayList<Student3> viewStudent() {
		
		ArrayList<Student3> al = new ArrayList<Student3>();
		
		try {
			PreparedStatement ps = cn.prepareStatement("select * from student3");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student3 st = new Student3();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setNum(rs.getString(4));
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
			PreparedStatement ps = cn.prepareStatement("delete from student3 where id=?");
			ps.setInt(1, id);
			
			i = ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}

}
