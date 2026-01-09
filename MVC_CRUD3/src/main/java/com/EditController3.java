package com;

import java.io.IOException;

import dao.Student3dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student3;

@WebServlet("/edit3")
public class EditController3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("eid"));
		
		Student3dao dao = new Student3dao();
		Student3 st2 = dao.getElementById(id);
		
		req.setAttribute("std03", st2);
		req.getRequestDispatcher("update3.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int nid = Integer.parseInt(req.getParameter("ID"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String num = req.getParameter("num");
		
		Student3 st = new Student3();
		st.setId(nid);
		st.setName(name);
		st.setEmail(email);
		st.setNum(num);
		
		Student3dao dao = new Student3dao();
		int i2 = dao.updateStudent(st);
		
		if(i2>0) {
			req.setAttribute("msg2", "Updated Successfully");
			req.getRequestDispatcher("update3.jsp").forward(req, resp);
		}
		
	}
}
