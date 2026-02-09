package controller;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student6;

@WebServlet("/edit6")
public class UpdateController6 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("eid"));
		
		StudentDao dao = new StudentDao();
		Student6 st = dao.getElementById(id);
		
		req.setAttribute("stdata6", st);
		req.getRequestDispatcher("update6.jsp").forward(req, resp);
		
//		System.out.println("done");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int iid = Integer.parseInt(req.getParameter("newid"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String city = req.getParameter("city");
		
		Student6 st = new Student6();
		st.setId(iid);
		st.setName(name);
		st.setEmail(email);
		st.setCity(city);
		
		StudentDao dao = new StudentDao();
		int j = dao.updateStudent(st);
		
		if(j>0) {
			req.setAttribute("msg2", "Updated Successfully");
			req.getRequestDispatcher("update6.jsp").forward(req, resp);
		}
	}
}
