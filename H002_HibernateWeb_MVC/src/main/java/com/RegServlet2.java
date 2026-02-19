package com;

import java.io.IOException;

import dao.StudentDao2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student2;

@WebServlet("/reg")
public class RegServlet2 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String age = req.getParameter("age");
		
		Student2 st = new Student2();
		st.setName(name);
		st.setEmail(email);
		st.setAge(age);
		
		StudentDao2 dao = new StudentDao2();
		int i = dao.addStudent(st);
		if(i>0) {
			req.setAttribute("mesg","successfully done");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
		
	}

}
