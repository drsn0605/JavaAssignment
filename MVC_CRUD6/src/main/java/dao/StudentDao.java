package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student6;

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
	
	public int addStudent(Student6 st) {
		int i = 0;
		
		try {
			PreparedStatement ps = cn.prepareStatement("insert into Student6 values(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, st.getName());
			ps.setString(3, st.getEmail());
			ps.setString(4, st.getPhone());
			
			i = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<Student6> viewStudent6() {
		
		ArrayList<Student6> al = new ArrayList<Student6>();
		
		try {
			PreparedStatement ps = cn.prepareStatement("select * from student6");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student6 st = new Student6();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setPhone(rs.getString(4));
				al.add(st);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

	public int deleteStudent(int id) {
		int i =0;
		
		try {
			PreparedStatement ps = cn.prepareStatement("delete from student6 where id=?");
			ps.setInt(1, id);
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public Student6 getElementById(int id) {
		
		Student6 st = new Student6();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from student6 where id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
		
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setPhone(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
		
	}

	public int updateStudent(Student6 st) {
		int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("update student6 set name=?, email=?, phone=? where id=?");
			ps.setString(1, st.getName());
			ps.setString(2, st.getEmail());
			ps.setString(3, st.getPhone());
			ps.setInt(4, st.getId());
			
			i = ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
}
