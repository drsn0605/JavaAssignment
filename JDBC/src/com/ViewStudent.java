package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewStudent {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");      //surround with try/catch
			System.out.println("Driver loaded");
			
			String url = "jdbc:mysql://localhost:3306/28aug_2025_java";
			String username = "root";
			String password = "drsn@1028";    
			
			Connection cn = DriverManager.getConnection(url,username,password);    //add exception to existing catch clause
			System.out.println("connection established");            //here cn is a reference variable of Connection.
            //It stores the connection object returned by getConnection.
			//DriverManager.getConnection(....) - Asks the database driver (MySQL driver) to open a connection.
			
			Statement st = cn.createStatement();
			
			ResultSet rs = st.executeQuery("select * from student");
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);    //here 2 is column index 
				String email = rs.getString("email");    //we can also write column name - email.
				
				System.out.println(id+" "+name+" "+email+" ");
				
			}
			cn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
		
	}

}
