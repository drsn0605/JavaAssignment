package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User3;

public class UserDao3 {
	Connection cn = null;
	
	public UserDao3() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","drsn@1028");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int addUser(User3 user) {
		
		int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("insert into user3 values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPass());
			ps.setString(5, user.getGender());
			ps.setString(6, user.getLang());
			ps.setString(7, user.getCountry());
			ps.setString(8, user.getAddress());
			
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
			PreparedStatement ps = cn.prepareStatement("select * from user3 where email=?");
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

	public User3 loginCheck(User3 user) {
		
		User3 u = null;
		try {
			PreparedStatement ps = cn.prepareStatement("select * from user3 where email=? and pass=?");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPass());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new User3();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPass(rs.getString(4));
				u.setGender(rs.getString(5));
				u.setLang(rs.getString(6));
				u.setCountry(rs.getString(7));
				u.setAddress(rs.getString(8));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
		
	}

}
