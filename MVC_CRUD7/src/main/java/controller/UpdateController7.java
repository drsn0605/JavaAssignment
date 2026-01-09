package controller;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student7;

@WebServlet("/edit7")
public class UpdateController7 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("eid"));
		
		StudentDao dao = new StudentDao();
		Student7 st = dao.getElementById(id);
		
		req.setAttribute("stdata", st);
		req.getRequestDispatcher("update7.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int iid = Integer.parseInt(req.getParameter("id7"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		
		Student7 st = new Student7();
		st.setId(iid);
		st.setName(name);
		st.setEmail(email);
		st.setCountry(country);
		
		StudentDao dao = new StudentDao();
		int j = dao.updateStudent(st);
		
		if(j>0) {
			req.setAttribute("msg2", "Updated Successfully");
			req.getRequestDispatcher("update7.jsp").forward(req, resp);
		}
	}
}
