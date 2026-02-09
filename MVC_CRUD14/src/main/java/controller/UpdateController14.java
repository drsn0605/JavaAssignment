package controller;

import java.io.IOException;

import dao.StudentDao14;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student14;

@WebServlet("/edit14")
public class UpdateController14 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("eid"));
		
		StudentDao14 dao = new StudentDao14();
		Student14 st = dao.getElementById(id);
		
		req.setAttribute("stdata", st);
		req.getRequestDispatcher("update14.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("uname");
		String email = req.getParameter("email");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		
		Student14 st = new Student14();
		st.setId(id);
		st.setName(name);
		st.setEmail(email);
		st.setState(state);
		st.setCountry(country);
		
		StudentDao14 dao = new StudentDao14();
		int j = dao.updateStudent(st);
		
		if(j>0) {
			req.setAttribute("msg", "Updated Successfully");
			req.getRequestDispatcher("update14.jsp").forward(req, resp);
		}
	}
}
