package com;

import java.io.IOException;
import java.util.ArrayList;

import dao.Student3dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student3;

@WebServlet("/display3")
public class DisplayController3 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("done");
		Student3dao dao = new Student3dao();
		ArrayList<Student3> al = dao.viewStudent();
		
		req.setAttribute("data123", al);
		req.getRequestDispatcher("display3.jsp").forward(req, resp);
		
	}

}
