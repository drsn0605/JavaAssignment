package com;

import java.io.IOException;

import dao.StudentDao2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteController2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("done");
		
//		String id = req.getParameter("stid");  //this id will always comes in String datatype. But we want that in Integer type.So, we have to cast it into Integer.
		int id = Integer.parseInt(req.getParameter("stid"));
		
		StudentDao2 dao = new StudentDao2();
		int i = dao.deleteStudent(id);
		
		if(i>0) {

			req.getRequestDispatcher("display").forward(req, resp);
		}
		
	}
}
