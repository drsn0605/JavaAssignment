package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User4;

public class UserDao4 {
	
	Connection cn = null;
	public UserDao4() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","drsn@1028");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int addUser(User4 user) {
		
		int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("insert into user4 values(?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, user.getName());
			ps.setString(3, user.getSurname());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getLang());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public boolean isEmailExist(String email) {
		
		boolean b = false;
		
		try {
			PreparedStatement ps = cn.prepareStatement("select * from user4 where email=?");
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				b = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
	public User4 loginCheck(User4 user) {
		
		User4 u = null;
		try {
			PreparedStatement ps = cn.prepareStatement("select * from user4 where email=? and password=?");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new User4();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setSurname(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
				u.setLang(rs.getString(6));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
		
	}
}
