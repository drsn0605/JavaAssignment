package controller;

import java.io.IOException;

import dao.StudentDao9;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student9;

@WebServlet("/reg9")
public class RegController9 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("done");
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String village = req.getParameter("village");
		
//		System.out.println("done");
		Student9 st = new Student9();
		
		st.setName(name);
		st.setEmail(email);
		st.setVillage(village);
		
		StudentDao9 dao = new StudentDao9();
		int i = dao.addStudent(st);
		
		while(i>0) {
			req.setAttribute("message", "successfully register");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
		
	}

}
