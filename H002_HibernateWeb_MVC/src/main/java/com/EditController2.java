package com;

import java.io.IOException;

import dao.StudentDao2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student2;

@WebServlet("/edit2")
public class EditController2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("eid"));
		
		StudentDao2 dao = new StudentDao2();
		Student2 nst = dao.getElementById(id);
		
		req.setAttribute("std02", nst);
		req.getRequestDispatcher("update2.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int mid = Integer.parseInt(req.getParameter("nid"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String age = req.getParameter("age");
		
		Student2 st = new Student2();
		st.setId(mid);
		st.setName(name);
		st.setEmail(email);
		st.setAge(age);
		
		StudentDao2 dao = new StudentDao2();
		int i2 = dao.updateStudent(st);
		
		if(i2>0) {
			req.setAttribute("msg2", "Updated Successfully");
			req.getRequestDispatcher("update2.jsp").forward(req, resp);
		}
		
	}
}


