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

@WebServlet("/cover")
public class CoverServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nname = req.getParameter("nickname");
		String city = req.getParameter("city");
		String sport = req.getParameter("sport");
		String age = req.getParameter("age");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","drsn@1028");
			
			PreparedStatement ps = cn.prepareStatement("insert into sportsteam values(?,?,?,?,?)");
			ps.setInt(1,0);
			ps.setString(2, nname);
			ps.setString(3, city);
			ps.setString(4, sport);
			ps.setString(5, age);
			
			int i = ps.executeUpdate();
			
			if(i>0) {
//				System.out.println("done");
				req.setAttribute("message", "done!!");
				req.getRequestDispatcher("cover.jsp").forward(req, resp);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
