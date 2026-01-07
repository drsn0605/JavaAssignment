package controller;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete5")
public class DeleteController4 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id = req.getParameter("stid");
		int id = Integer.parseInt(req.getParameter("stid"));
		
		StudentDao dao = new StudentDao();
		int i = dao.deleteStudent(id);
		
		if(i>0) {
			req.getRequestDispatcher("display5").forward(req, resp);
		}
	}
}
