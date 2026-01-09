package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.StudentDao13;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student13;

@WebServlet("/display13")
public class DisplayController13 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDao13 dao = new StudentDao13();
		ArrayList<Student13> al = dao.displayStudent();
		
		req.setAttribute("data13", al);
		req.getRequestDispatcher("display13.jsp").forward(req, resp);
		
	}
}
