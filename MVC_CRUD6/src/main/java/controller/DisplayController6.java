package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student6;

@WebServlet("/display6")
public class DisplayController6 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDao dao = new StudentDao();
		ArrayList<Student6> al = dao.viewStudent6();
		
//		System.out.println("done");
		
		req.setAttribute("data6", al);
		req.getRequestDispatcher("display6.jsp").forward(req, resp);
	}
}
