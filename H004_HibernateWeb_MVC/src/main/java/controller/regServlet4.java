package controller;

import java.io.IOException;

import dao.Studentdao4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student4;

@WebServlet("/reg4")
public class regServlet4 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String hometown = req.getParameter("hometown");
		
		Student4 st = new Student4();
		st.setId(0);
		st.setName(name);
		st.setEmail(email);
		st.setHometown(hometown);
		
		Studentdao4 dao = new Studentdao4();
		int i = dao.addStudent4(st);
		
		while(i>0) {
			req.setAttribute("msg4", "done successfully");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
		
	}

}
