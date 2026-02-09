package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student01;

public class StudentDao {
	
	Connection cn = null;
	
	public StudentDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","drsn@1028");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int addStudent(Student01 st) {
		int i = 0;
		
		try {
			PreparedStatement ps = cn.prepareStatement("insert into student values(?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, st.getName());
			ps.setString(3, st.getEmail());
			ps.setString(4, st.getCourse());
			ps.setString(5, st.getAge());
			ps.setString(6, st.getCreatedAt());
			
			
			i = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<Student01> viewStudent() {
		
		ArrayList<Student01> al = new ArrayList<Student01>();
		
		try {
			PreparedStatement ps = cn.prepareStatement("select * from student");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student01 st = new Student01();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setCourse(rs.getString(4));
				st.setAge(rs.getString(5));
				st.setCreatedAt(rs.getString(6));
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
			PreparedStatement ps = cn.prepareStatement("delete from student where id=?");
			ps.setInt(1, id);
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public Student01 getElementById(int id) {
		
		Student01 st = new Student01();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from student where id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
		
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setCourse(rs.getString(4));
				st.setAge(rs.getString(5));
				st.setCreatedAt(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
		
	}

	public int updateStudent(Student01 st) {
		int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("update student set name=?, email=?, course=?, age=?, createdAt=? where id=?");
			ps.setString(1, st.getName());
			ps.setString(2, st.getEmail());
			ps.setString(3, st.getCourse());
			ps.setString(4, st.getAge());
			ps.setString(5, st.getCreatedAt());
			ps.setInt(6, st.getId());
			
			i = ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
}
