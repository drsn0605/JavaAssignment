package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student5;

@WebServlet("/display5")
public class DisplayController5 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDao dao = new StudentDao();
		ArrayList<Student5> al  = dao.viewStudent();
		
		req.setAttribute("data5", al);
		req.getRequestDispatcher("display5.jsp").forward(req, resp);
	}
}
