package controller;

import java.io.IOException;

import dao.StudentDao12;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete12")
public class DeleteController12 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id = req.getParameter("stid");
		int id = Integer.parseInt(req.getParameter("stid"));
		
		StudentDao12 dao = new StudentDao12();
		int j = dao.deleteStudent(id);
		
		if(j>0) {
			
			req.getRequestDispatcher("display12").forward(req, resp);
		}
	}
}
