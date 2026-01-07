package controller;

import java.io.IOException;

import dao.StudentDao11;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student11;

@WebServlet("/reg11")
public class RegController11 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String institute = req.getParameter("institute");
		
		Student11 st = new Student11();
		st.setId(0);
		st.setName(name);
		st.setEmail(email);
		st.setInstitute(institute);
		
		StudentDao11 dao = new StudentDao11();
		int j = dao.addStudent(st);
		
		if(j>0) {
			req.setAttribute("msg", "register Successfully");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
