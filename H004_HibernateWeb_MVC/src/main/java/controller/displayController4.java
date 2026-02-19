package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.Studentdao4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student4;

@WebServlet("/display4")
public class displayController4 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		Studentdao4 dao = new Studentdao4();
		ArrayList<Student4> al = dao.viewStudent();
		
		req.setAttribute("datta", al);
		req.getRequestDispatcher("display4.jsp").forward(req, resp);
		
		
	}
}
