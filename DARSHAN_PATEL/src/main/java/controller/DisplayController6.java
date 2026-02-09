package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student01;

@WebServlet("/display")
public class DisplayController6 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDao dao = new StudentDao();
		ArrayList<Student01> al = dao.viewStudent();
		
		req.setAttribute("data01", al);
		req.getRequestDispatcher("display.jsp").forward(req, resp);
	}
}
