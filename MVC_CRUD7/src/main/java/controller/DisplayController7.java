package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student7;

@WebServlet("/display7")
public class DisplayController7 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDao dao = new StudentDao();
		ArrayList<Student7> al = dao.viewStudent7();

		req.setAttribute("data7", al);
		req.getRequestDispatcher("display7.jsp").forward(req, resp);
	}
}
