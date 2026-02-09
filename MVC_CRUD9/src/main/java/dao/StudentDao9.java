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
				st.setId(rs.getInt(1));      //dont forget to get id from rs... dont write st.getId(1) instead st.getId(rs.getInt(1));
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

	public int deleteStudent(int id) {
		
		int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("delete from student09 where id=?");
			ps.setInt(1, id);
			
			i = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public Student9 getElementByid(int id) {
		Student9 st = new Student9();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from student09 where id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setVillage(rs.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
		
	}

	public int updateStudent(Student9 st) {
		int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("update student09 set name=?, email=?, village=? where id=?");
			ps.setString(1, st.getName());
			ps.setString(2, st.getEmail());
			ps.setString(3, st.getVillage());
			ps.setInt(4, st.getId());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
}
