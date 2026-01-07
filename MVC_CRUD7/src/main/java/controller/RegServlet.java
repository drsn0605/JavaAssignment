package controller;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student7;

@WebServlet("/reg7")
public class RegServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("done");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		
		Student7 st = new Student7();
		st.setId(0);
		st.setName(name);
		st.setEmail(email);
		st.setCountry(country);
		
		StudentDao dao = new StudentDao();
		int i = dao.addStudent(st);
		
		while(i>0) {
			req.setAttribute("msg", "done dona done");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
		
	}
	

}
