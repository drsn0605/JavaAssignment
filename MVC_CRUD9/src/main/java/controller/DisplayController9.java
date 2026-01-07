package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.StudentDao9;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student9;

@WebServlet("/display9")
public class DisplayController9 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("donedone");
		
		StudentDao9 dao = new StudentDao9();
		ArrayList<Student9> al = dao.viewStudent();
		
		req.setAttribute("data9", al);
		req.getRequestDispatcher("display9.jsp").forward(req, resp);
	}

}
