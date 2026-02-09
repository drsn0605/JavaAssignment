package controller;

import java.io.IOException;

import dao.StudentDao9;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete9")
public class DeleteController9 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("stid"));
		
		StudentDao9 dao = new StudentDao9();
		int i = dao.deleteStudent(id);
		
		if(i>0) {
			req.getRequestDispatcher("display9").forward(req, resp);
		}
	}
}
