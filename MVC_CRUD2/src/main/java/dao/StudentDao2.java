package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student2;

public class StudentDao2 {
	
	Connection cn = null;
	
	public StudentDao2() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","drsn@1028");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int addStudent(Student2 st) {
		int i = 0;
		
		try {
			PreparedStatement ps = cn.prepareStatement("insert into stdinfo values(?,?,?,?)");
			ps.setInt(1,0);
			ps.setString(2, st.getName());
			ps.setString(3, st.getEmail());
			ps.setString(4, st.getAge());
			
			i = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
		
	}
	
	public ArrayList<Student2> viewStudent() {
		
		ArrayList<Student2> al = new ArrayList<Student2>();
		
		try {
			PreparedStatement ps = cn.prepareStatement("select * from stdinfo");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//we need to get details from Student2 clas, So we have to create object of Student2 class.
				Student2 st = new Student2();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setAge(rs.getString(4));
				
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
			PreparedStatement ps = cn.prepareStatement("delete from stdinfo where id=?");
			ps.setInt(1,id);
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public Student2 getElementById(int id) {
		
		Student2 st = new Student2();   //agar while ke under object banayenge to st return nahi ho payega.. So hame object yaha hi banana padega.
		try {
			PreparedStatement ps = cn.prepareStatement("select * from stdinfo where id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setAge(rs.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
		
	}

	public int updateStudent(Student2 st) {
		
		int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("update stdinfo set name=?, email=?, age=? where id=?");
			ps.setString(1, st.getName());
			ps.setString(2, st.getEmail());
			ps.setString(3, st.getAge());
			ps.setInt(4, st.getId());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	
	}
	
}
