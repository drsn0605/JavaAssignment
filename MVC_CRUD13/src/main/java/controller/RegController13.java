package controller;

import java.io.IOException;

import dao.StudentDao13;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student13;

@WebServlet("/reg13")
public class RegController13 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		
		Student13 st = new Student13();
		st.setId(0);
		st.setName(name);
		st.setEmail(email);
		st.setState(state);
		st.setCountry(country);
		
		StudentDao13 dao = new StudentDao13();
		int i = dao.addStudent(st);
		
		if(i>0) {
			req.setAttribute("msg", "Register Successfully");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
	}
}
