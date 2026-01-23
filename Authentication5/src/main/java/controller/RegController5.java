package controller;

import java.io.IOException;

import dao.StudentDao5;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student5;

@WebServlet("/reg5")
public class RegController5 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String lang[] = req.getParameterValues("lang");
		String option = req.getParameter("option");
		
		String lng = "";
		for(String l : lang) {
			lng = lng + l + ",";
		}
		
		Student5 st = new Student5();
		st.setName(name);
		st.setSurname(surname);
		st.setEmail(email);
		st.setPass(pass);
		st.setLang(lng);
		st.setOption(option);
		
		StudentDao5 dao = new StudentDao5();
		int i = dao.addStudent(st);
		
		if(i>0) {
			req.setAttribute("msg5", "Register successfully");
			req.getRequestDispatcher("reg5.jsp").forward(req, resp);
		}
		
	}
}
