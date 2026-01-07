package com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementDemo {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/28aug_2025_java";
			String user = "root";
			String pass = "drsn@1028";
			
			Connection cn = DriverManager.getConnection(url,user,pass);
			
			CallableStatement cb = cn.prepareCall("call stds()");
			
			ResultSet rs = cb.executeQuery();
			
//			while(rs.next()) {
//				int id = rs.getInt(1);     //here we can write id also instead of 1
//				String name = rs.getString(2);      //here we can write name also instead of 2
//				String email = rs.getString(3);       //here we can write email also instead of 3
//				System.out.println(id+" "+name+" "+email);
//			}
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
