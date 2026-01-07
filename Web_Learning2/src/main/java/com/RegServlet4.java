package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home4")
public class RegServlet4 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("uname");
		String email = req.getParameter("email");
		String passcode = req.getParameter("passcode");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","drsn@1028");
			
			PreparedStatement ps = cn.prepareStatement("insert into homedb4 values(?,?,?,?)");
			ps.setInt(1, 0);  //here 1 is indicating the 1st ? (1st column) & 0 is indicating that the 1st column(id) is Auto-Increment.
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, passcode);
			
			int i = ps.executeUpdate();
			
			if(i>0) {
//				System.out.println("done");
				req.setAttribute("mssg", "Done!!");
				req.getRequestDispatcher("home4.jsp").forward(req, resp);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
}
