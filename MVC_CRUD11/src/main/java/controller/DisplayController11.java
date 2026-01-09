package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.StudentDao11;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student11;

@WebServlet("/display11")
public class DisplayController11 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDao11 dao = new StudentDao11();
		ArrayList<Student11> al = dao.viewStudent();
		
		req.setAttribute("data11", al);
		req.getRequestDispatcher("display11.jsp").forward(req, resp);
	}
}
