package controller;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student5;

@WebServlet("/reg5")
public class IndexServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String city = req.getParameter("city");
		
		Student5 st = new Student5();
		st.setId(0);
		st.setName(name);
		st.setEmail(email);
		st.setCity(city);
		
		StudentDao dao = new StudentDao();
		int i = dao.addStudent(st);
		
		while(i>0) {
			req.setAttribute("msg", "register successfully");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
		
		
	}

}
