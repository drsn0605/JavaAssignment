package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet("/display")
public class DisplayController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao dao = new StudentDao();  //1st
		ArrayList<Student> al = dao.viewStudents();   //calling viewStudent method  + 9th 
		
		req.setAttribute("data", al);    //al data is calling through this line &   + 10th 
		req.getRequestDispatcher("display.jsp").forward(req, resp);   //al data sent to display.jsp  + 11th
		
	}

}
