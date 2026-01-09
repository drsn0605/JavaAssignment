package controller;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student6;

@WebServlet("/reg6")
public class IndexServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("done");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		Student6 st = new Student6();
		st.setId(0);
		st.setName(name);
		st.setEmail(email);
		st.setPhone(phone);
		
		StudentDao dao = new StudentDao();
//		dao.addStudent(st);    //isko hum i me save kar lenge.
		int i = dao.addStudent(st);
		
		if(i>0) {
			req.setAttribute("msg", "done successfully");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

}
