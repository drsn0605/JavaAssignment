package controller;

import java.io.IOException;

import dao.StudentDao10;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student10;

@WebServlet("/reg10")
public class RegController10 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String city = req.getParameter("city");
		
		Student10 st = new Student10();
		st.setId(0);
		st.setName(name);
		st.setEmail(email);
		st.setCity(city);
		
		StudentDao10 dao = new StudentDao10();
		int j = dao.addStudent(st);
		
		while(j>0) {
			req.setAttribute("msg", "Register Successfully");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
