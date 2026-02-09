package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student8;

public class StudentDao {

	Connection cn = null;
	public StudentDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","drsn@1028");
				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int addStudent(Student8 st) {
		
		int i=0;
		
		try {
			PreparedStatement ps = cn.prepareStatement("insert into Student8 values(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, st.getName());
			ps.setString(3, st.getEmail());
			ps.setString(4, st.getState());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return i;
		
	}

	public ArrayList<Student8> viewStudent() {
		
		ArrayList<Student8> al = new ArrayList<Student8>();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from Student8");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student8 st = new Student8();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setState(rs.getString(4));
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
			PreparedStatement ps = cn.prepareStatement("delete from Student8 where id=?");
			ps.setInt(1, id);
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public Student8 getElementById(int id) {
		
		Student8 st = new Student8();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from Student8 where id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setState(rs.getString(4));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return st;
	}

	public int updateStudent(Student8 st) {
		
		int i = 0;
		
		try {
			PreparedStatement ps = cn.prepareStatement("update Student8 set name=?, email=?, state=? where id=?");
			ps.setString(1, st.getName());
			ps.setString(2, st.getEmail());
			ps.setString(3, st.getState());
			ps.setInt(4, st.getId());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
}
