package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student8;

@WebServlet("/display8")
public class DisplayController8 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao dao = new StudentDao();
		ArrayList<Student8> al = dao.viewStudent();
		
		req.setAttribute("data", al);
		req.getRequestDispatcher("display8.jsp").forward(req, resp);
		
	}
}
