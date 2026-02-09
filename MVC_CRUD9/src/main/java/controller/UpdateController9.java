package controller;

import java.io.IOException;

import dao.StudentDao9;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student9;

@WebServlet("/edit9")
public class UpdateController9 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("eid"));
		
		StudentDao9 dao = new StudentDao9();
		Student9 st = dao.getElementByid(id);
		
		req.setAttribute("sdata", st);
		req.getRequestDispatcher("update9.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String village = req.getParameter("village");
		
		Student9 st = new Student9();
		st.setId(id);
		st.setName(name);
		st.setEmail(email);
		st.setVillage(village);
		
		StudentDao9 dao = new StudentDao9();
		int z = dao.updateStudent(st);
		
		if(z>0) {
			req.setAttribute("msg", "Updated Successfully");
			req.getRequestDispatcher("update9.jsp").forward(req, resp);
		}
		
	}
}
