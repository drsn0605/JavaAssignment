package controller;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student8;

@WebServlet("/edit8")
public class UpdateController8 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("eid"));
		
		StudentDao dao = new StudentDao();
		Student8 st = dao.getElementById(id);
		
		req.setAttribute("stdata", st);
		req.getRequestDispatcher("update8.jsp").forward(req, resp);
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id7"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String state = req.getParameter("state");
		
		Student8 st = new Student8();
		st.setId(id);
		st.setName(name);
		st.setEmail(email);
		st.setState(state);
		
		StudentDao dao = new StudentDao();
		int f = dao.updateStudent(st);
		
		if(f>0) {
			req.setAttribute("msg", "Update Successfully");
			req.getRequestDispatcher("update8.jsp").forward(req, resp);
		}
	}
}
