package controller;

import java.io.IOException;

import dao.Studentdao4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete4")
public class DeleteController4 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String id = req.getParameter("stid");
		int id = Integer.parseInt(req.getParameter("stid"));
		
		Studentdao4 dao = new Studentdao4();
		int i = dao.deleteStudent(id);
		
		if(i>0) {
			req.getRequestDispatcher("display4").forward(req, resp);
		}
		
	}
}
