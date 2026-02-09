package controller;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete8")
public class DeleteController8 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("stid"));
		
		StudentDao dao = new StudentDao();
		int j = dao.deleteStudent(id);
		
		if(j>0) {
			req.getRequestDispatcher("display8").forward(req, resp);
		}
	}
}
