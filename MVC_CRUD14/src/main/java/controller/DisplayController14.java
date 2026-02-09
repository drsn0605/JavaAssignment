package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.StudentDao14;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student14;

@WebServlet("/display14")
public class DisplayController14 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDao14 dao = new StudentDao14();
		ArrayList<Student14> al = dao.viewStudent();
		
		req.setAttribute("stdata", al);
		req.getRequestDispatcher("display14.jsp").forward(req, resp);
	}
}
