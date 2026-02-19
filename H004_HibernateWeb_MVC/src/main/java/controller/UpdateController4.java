package controller;

import java.io.IOException;

import dao.Studentdao4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student4;

@WebServlet("/edit4")
public class UpdateController4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("eid"));
		
		Studentdao4 dao = new Studentdao4();
		Student4 st = dao.getElementById(id);
		
		req.setAttribute("stdata", st);
		req.getRequestDispatcher("update4.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int lid = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String hometown = req.getParameter("hometown");
		
//		System.out.println("done");
		
		Student4 st = new Student4();
		st.setId(lid);
		st.setName(name);
		st.setEmail(email);
		st.setHometown(hometown);
		
		Studentdao4 dao = new Studentdao4();
		int ij = dao.updateStudent(st);
		
		if(ij>0) {
			req.setAttribute("msg2", "Updated Successfully");
			req.getRequestDispatcher("update4.jsp").forward(req, resp);
		}
	}
}
