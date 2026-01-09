package controller;

import java.io.IOException;

import dao.StudentDao11;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete11")
public class DeleteController11 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String id = req.getParameter("stid");
		int id = Integer.parseInt(req.getParameter("stid"));
		
		StudentDao11 dao = new StudentDao11();
		int j = dao.deleteStudent(id);
		
		if(j>0) {
			
			req.getRequestDispatcher("display11").forward(req, resp);
		}
		
		
	}
}
