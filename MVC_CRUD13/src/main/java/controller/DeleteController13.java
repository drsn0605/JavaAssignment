package controller;

import java.io.IOException;

import dao.StudentDao13;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteController13 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("stid"));
		
		StudentDao13 dao = new StudentDao13();
		int i = dao.deleteStudent(id);
		
		if(i>0) {
			req.getRequestDispatcher("display13").forward(req, resp);
		}
	}
}
