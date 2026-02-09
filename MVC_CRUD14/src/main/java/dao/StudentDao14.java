package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student14;

public class StudentDao14 {
	
	Connection cn = null;
	
	public StudentDao14() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","drsn@1028");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int addUser(Student14 st) {
		int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("insert into stdinfo14 values(?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, st.getName());
			ps.setString(3, st.getEmail());
			ps.setString(4, st.getState());
			ps.setString(5, st.getCountry());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<Student14> viewStudent() {
		
		ArrayList<Student14> al = new ArrayList<Student14>();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from stdinfo14");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student14 st = new Student14();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setState(rs.getString(4));
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
		int i =0;
		try {
			PreparedStatement ps = cn.prepareStatement("delete from stdinfo14 where id=?");
			ps.setInt(1, id);
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}

	public Student14 getElementById(int id) {
		
		Student14 st = new Student14();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from stdinfo14 where id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setState(rs.getString(4));
				st.setCountry(rs.getString(5));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
		
	}

	public int updateStudent(Student14 st) {
			int i = 0;
			try {
				PreparedStatement ps = cn.prepareStatement("update stdinfo14 set name=?, email=?, state=?, country=? where id=?");
				ps.setString(1, st.getName());
				ps.setString(2, st.getEmail());
				ps.setString(3, st.getState());
				ps.setString(4, st.getCountry());
				ps.setInt(5, st.getId());
				
				i = ps.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
	}
	
}
