package com;

import java.io.IOException;

import dao.Student3dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student3;

@WebServlet("/reg3")
public class indexServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String num = req.getParameter("num");
		
		Student3 st = new Student3();
		st.setName(name);
		st.setEmail(email);
		st.setNum(num);
		
		Student3dao dao = new Student3dao();
		int i = dao.addStudent(st);
		if(i>0) {
			
			req.setAttribute("msg", "done successfully");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
	

}
