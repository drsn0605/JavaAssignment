package controller;

import java.io.IOException;

import dao.StudentDao14;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student14;

@WebServlet("/reg14")
public class RegController14 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("uname");
		String email = req.getParameter("email");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		
		Student14 st = new Student14();
		st.setName(name);
		st.setEmail(email);
		st.setState(state);
		st.setCountry(country);
		
		StudentDao14 dao = new StudentDao14();
		int j = dao.addUser(st);
		
		if(j>0) {
			req.setAttribute("msg", "Register successfully");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
