package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteStudent {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id : ");
		int id = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/28aug_2025_java";
			String user = "root";
			String password = "drsn@1028";
			
			Connection cn = DriverManager.getConnection(url,user,password);
			
			Statement st = cn.createStatement();
			
			int i = st.executeUpdate("delete from student where id = "+id);
			
			if(i>0) {
				System.out.println("student deleted");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
		
	}

}
