package com;

import java.io.IOException;
import java.util.ArrayList;

import dao.StudentDao2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student2;

@WebServlet("/display")
public class DisplayController2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("done");
		StudentDao2 dao = new StudentDao2();
		ArrayList<Student2> al = dao.viewStudent();     
		
		req.setAttribute("data", al);
		req.getRequestDispatcher("display2.jsp").forward(req, resp);
	}
	

}
