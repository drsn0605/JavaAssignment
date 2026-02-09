package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//for static data..
		String q = req.getParameter("q");
		PrintWriter pw = resp.getWriter();
		String data="";
		
		if(q.equals("electric")) {
			data = "<ul><li>Fan</li> <li>Switch</li> <li>Light</li> <li>Bulb</li>";
		}
		else if(q.equals("cloths")) {
			data = "<ul><li>Tshirt</li> <li>Jeans</li> <li>Jacket</li> <li>Shirt</li>";
		}
		else if(q.equals("sports")) {
			data = "<ul><li>Bat</li> <li>Ball</li> <li>Stump</li> <li>Racketvcxx</li>";
		}
		else {
			data = "no data found";
		}
		
		pw.append(data);
		
		
		//for dynamic data..(Connect with DB)
//		String q = req.getParameter("q");
//		PrintWriter pw = resp.getWriter();
//		String data = "";
//		 
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","drsn@1028");
//			
//			Statement st = cn.createStatement();
//			
//			data = data + "<ul>";
//			ResultSet rs = st.executeQuery("select * from products where name like '"+q+"%' ");
//			
//			while(rs.next()) {
//				data = data + "<li>" + rs.getString(2) + "</li>";
//			}
//			data = data + "</ul>";
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		pw.append(data);
		
	}
}
