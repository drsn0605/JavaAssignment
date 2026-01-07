package com;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaData {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/28aug_2025_java";
			String user = "root";
			String pass = "drsn@1028";
			
			Connection cn = DriverManager.getConnection(url,user,pass);
			
			DatabaseMetaData dm = cn.getMetaData();
			System.out.println(dm.getDriverMajorVersion());
			System.out.println(dm.getDriverName());
			System.out.println(dm.getDriverVersion());
			
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from student");
			
			ResultSetMetaData rd = rs.getMetaData();
			System.out.println(rd.getColumnCount());
			System.out.println(rd.getColumnName(2));
			System.out.println(rd.getColumnTypeName(3));
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
