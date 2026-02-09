package com;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet("/Reg01")
public class RegServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String course = req.getParameter("course");
		String age = req.getParameter("age");
		String createdAt = req.getParameter("createdAt");
		
		Student st = new Student();
		st.setName(name);
		st.setEmail(email);
		st.setCourse(course);
		st.setAge(age);
		st.setCreatedAt(createdAt);
		
		StudentDao dao = new StudentDao();
		int i = dao.addStudent(st);
		
		if(i>0) {
			req.setAttribute("msg", "Register Successfully");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
	}
}
