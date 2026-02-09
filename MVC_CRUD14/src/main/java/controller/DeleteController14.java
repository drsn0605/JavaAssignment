package controller;

import java.io.IOException;

import dao.StudentDao14;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete14")
public class DeleteController14 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("stid"));
		
		StudentDao14 dao = new StudentDao14();
		int k = dao.deleteStudent(id);
		
		if(k>0) {
			req.getRequestDispatcher("display14").forward(req, resp);
		}
	}
}
