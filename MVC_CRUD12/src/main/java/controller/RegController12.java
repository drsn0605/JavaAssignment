package controller;

import java.io.IOException;

import dao.StudentDao12;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student12;

@WebServlet("/reg12")
public class RegController12 extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String city = req.getParameter("city");
		String country = req.getParameter("country");
		
		Student12 st = new Student12();
		st.setId(0);
		st.setName(name);
		st.setEmail(email);
		st.setCity(city);
		st.setCountry(country);
		
		StudentDao12 dao = new StudentDao12();
		int j = dao.addStudent(st);
		
		if(j>0) {
			req.setAttribute("msg", "Register Successfully");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

}
