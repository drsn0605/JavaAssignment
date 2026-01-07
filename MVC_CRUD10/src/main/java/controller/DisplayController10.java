package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.StudentDao10;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student10;

@WebServlet("/display")
public class DisplayController10 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDao10 dao = new StudentDao10();
		ArrayList<Student10> al = dao.viewStudent();
		
		req.setAttribute("data10", al);
		req.getRequestDispatcher("display10.jsp").forward(req, resp);
	}
}
