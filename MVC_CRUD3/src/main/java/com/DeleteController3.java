package com;

import java.io.IOException;

import dao.Student3dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete3")
public class DeleteController3 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id = req.getParameter("stid");
		int id = Integer.parseInt(req.getParameter("stid"));
		
		Student3dao dao = new Student3dao();
		int i = dao.deleteStudent(id);
		
		if(i>0) {
			req.getRequestDispatcher("display3").forward(req, resp);
		}
		
	}
}
