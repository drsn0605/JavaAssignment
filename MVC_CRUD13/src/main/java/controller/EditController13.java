package controller;

import java.io.IOException;

import dao.StudentDao13;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student13;

@WebServlet("/edit")
public class EditController13 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("eid"));
		
		StudentDao13 dao = new StudentDao13();
		Student13 st = dao.getElementById(id);
		
//		System.out.println("done");
		
		
		
		req.setAttribute("stdata", st);
		req.getRequestDispatcher("update13.jsp").forward(req, resp);
		
//		System.out.println("done3");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int idd = Integer.parseInt(req.getParameter("iid"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		
		System.out.println("done1");
		Student13 st = new Student13();
		st.setId(idd);
		st.setName(name);
		st.setEmail(email);
		st.setState(state);
		st.setCountry(country);
		
		System.out.println("done2");
		
		StudentDao13 dao = new StudentDao13();
		int i = dao.updateStudent(st);
		
		System.out.println("done3");
		
		if(i>0) {
			req.setAttribute("msg2", "Updated Successfully");
			req.getRequestDispatcher("update13.jsp").forward(req, resp);
		}
		System.out.println("done4");
	}
}
