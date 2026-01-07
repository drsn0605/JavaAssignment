package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddStudent {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name : ");
		String name = sc.next();
		System.out.println("Enter email : ");
		String email = sc.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("driver loaded");
			
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/28aug_2025_java","root","drsn@1028");
			
			Statement st = cn.createStatement();
			
			int i = st.executeUpdate("insert into student values(0,'"+name+"','"+email+"')");
			if (i>0) {
				System.out.println("data added");
			}
			
			cn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
		
	}

}
