package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.StudentDao12;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student12;

@WebServlet("/display12")
public class DisplayController12 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDao12 dao = new StudentDao12();
		ArrayList<Student12> al2 = dao.viewStudent();
		
		req.setAttribute("data12", al2);
		req.getRequestDispatcher("display12.jsp").forward(req, resp);
	}
}
 